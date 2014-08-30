package com.marck.in.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marck.common.CommonUtil;
import com.marck.common.DateUtil;
import com.marck.common.SystemArguments;
import com.marck.common.dao.HDB;
import com.marck.common.model.Captcha;
import com.marck.common.model.User;

@Component("registerService")
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class RegisterService {
	
	@Autowired
	private HDB hdb;

	/**
	 * 查询用户
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public User getUser(String userName, String passWord) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.phone='"+userName+"' and u.passWord='"+CommonUtil.Md5(passWord)+"'";
		List<User> list = (List<User>) hdb.findHql(hql);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	/**
	 * 根据验证码判断是否注册
	 * @param user
	 * @param map 
	 * @return
	 */
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public void addUser(User user, Map<String, Object> map) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.phone='"+user.getPhone()+"'";
		List<User> list = (List<User>) hdb.findHql(hql);
		if(list.size() > 0){
			map.put("msg", "该用户已经注册");
			map.put("code", 0);
		}else{
			user.setPassword(CommonUtil.Md5(user.getPassword()));
			user.setIntegral(0);
			user.setLastlogin(DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"));
			user.setSignin(0);
			user.setSuccession(0);
			hdb.saveOrUpdate(user);
			map.put("msg", "注册成功");
			map.put("code", 1);
			map.put("data", user);
			map.put("test", "完成");
		}
	}

	/**
	 * 查找该电话是否注册过
	 * @param phone
	 * @return
	 */
	public User checkUser(String phone) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.phone ='"+phone+"'";
		List<User> list = (List<User>) hdb.findHql(hql);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	/**
	 * 短信验证注册
	 * @param user
	 * @param map
	 */
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public void addSmsUser(User user, Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		String hql = "from Captcha c where c.phone='"+user.getPhone()+"'";
		
		List<Captcha> captchas = (List<Captcha>) hdb.findHql(hql);
		
		if(captchas.size() <= 0){
			map.put("msg", "没有验证码信息，请先获取验证码");
			map.put("code", 0);
			return;
		}
		
		Captcha c = captchas.get(0);
		
		Long now = new Date().getTime();
		
		if( (now - Long.parseLong(c.getCaptchaTime())) > SystemArguments.captchaTime ){
			map.put("msg", "验证码已过期,请重新获取验证码");
			map.put("code", 0);
		}else if( user.getCaptcha().equals(c.getCaptcha()) && user.getPhone().equals(c.getPhone()) ){
			hql = "from User u where u.phone='"+user.getPhone()+"'";
			List<User> list = (List<User>) hdb.findHql(hql);
			if(list.size() > 0){
				map.put("msg", "该用户已经注册");
				map.put("code", 0);
			}else{
				addUser(user, map);
			}
		}else{
			map.put("msg", "验证码错误");
			map.put("code", 0);
		}

	}

	/**
	 * 通过用户手机查询帐号是否存在
	 * @param user
	 * @param map 
	 */
	public void selAccoutByPhone(User user, Map<String, Object> map) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.phone = '"+user.getPhone()+"' and u.id <> "+user.getId();
		
		List<User> users = (List<User>) hdb.findHql(hql);
		
		if(users.size() > 0){
			map.put("msg", "帐号已存在");
			map.put("isHave", true);
		}else{
			map.put("msg", "帐号可注册");
			map.put("isHave", false);
		}
		map.put("code", 1);
	}

}
