package com.marck.in.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marck.common.CommonUtil;
import com.marck.common.DateUtil;
import com.marck.common.PageUtil;
import com.marck.common.SystemArguments;
import com.marck.common.dao.HDB;
import com.marck.common.model.Captcha;
import com.marck.common.model.User;
import com.marck.common.model.UserMessage;

@Component("generalService")
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class GeneralService {
	
	@Autowired
	private HDB hdb;

	/**
	 * 签到
	 * @param user
	 * @param map 
	 */
	public void signin(User user, Map<String, Object> map) {
		// TODO Auto-generated method stub
		User u = (User) hdb.find(User.class, user.getId());
		
		Date lastsingin = DateUtil.StringToDate(u.getLastsignin());
		
		if( !"".equals(u.getLastsignin()) && DateUtil.compareDate(lastsingin, null, 0) == 0 ){
			map.put("msg", "今日已经签到，无法重复签到!");
			map.put("code", 0);
			return;
		}
		
		if( !"".equals(u.getLastsignin()) && DateUtil.compareDate(lastsingin, null, 0) == 1){
			u.setSuccession(u.getSuccession()+1);
			if(u.getSuccession() < 6){
				u.setIntegral(u.getIntegral()+u.getSuccession());
			}else{
				u.setIntegral(u.getIntegral()+5);
			}
		}else{
			u.setSuccession(1);
			u.setIntegral(u.getIntegral()+1);
		}
		u.setSignin(u.getSignin()+1);
		u.setLastsignin(DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"));
		hdb.saveOrUpdate(u);
		map.put("msg", "签到成功");
		map.put("code", 1);
		map.put("data", u);
	}

	/**
	 * 发送信息到服务器
	 * @param user
	 * @param map
	 */
	public void sendMessage(UserMessage userMessage, Map<String, Object> map) {
		// TODO Auto-generated method stub
		userMessage.setAddTime(DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"));
		userMessage.setMessage(CommonUtil.changeIos8859ToUtf8(userMessage.getMessage()));
		hdb.saveOrUpdate(userMessage);
		map.put("msg", "发送成功");
		map.put("code", 1);
	}
	
	/**
	 * 查询列表
	 * @param type 
	 * @param time
	 * @param pageNo
	 * @param pageNum
	 * @param map
	 */
	public void selUserList(Integer type, String time, Integer pageNo,Integer pageNum,Map<String, Object> map){
		String hql = "";
		PageUtil pu = null;
		
		switch (type) {
		case 0:
			hql = "from User u ";
			
			if(!CommonUtil.validParams(time)){
				hql += " where u.lastlogin > '"+time+"'";
			}
			
			hql += " order by u.lastlogin desc";
			
			pu = hdb.findHql(hql, pageNo, pageNum);
			
			map.put("msg", "查询成功");
			map.put("code", 1);
			map.put("list", pu.getData());
			map.put("hasNext",pu.getHasNext());
			break;
		case 1:
			hql = "from UserMessage um ";
			
			if(!CommonUtil.validParams(time)){
				hql += " where um.addTime > '"+time+"'";
			}
			
			hql += " order by um.addTime desc";
			
			pu = hdb.findHql(hql, pageNo, pageNum);
			
			map.put("msg", "查询成功");
			map.put("code", 1);
			map.put("data", pu.getData());
			map.put("hasNext",pu.getHasNext());
			break;
		case 2:
			hql = "from User u ";
			
			if(!CommonUtil.validParams(time)){
				hql += " where u.lastsignin > '"+time+"'";
			}
			
			hql += " order by u.lastsignin desc";
			
			pu = hdb.findHql(hql, pageNo, pageNum);
			map.put("msg", "查询成功");
			map.put("code", 1);
			map.put("data", pu.getData());
			map.put("hasNext",pu.getHasNext());
			break;
		}
		
	}
	
}
