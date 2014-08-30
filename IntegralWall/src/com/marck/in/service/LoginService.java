package com.marck.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marck.common.CommonUtil;
import com.marck.common.DateUtil;
import com.marck.common.dao.HDB;
import com.marck.common.model.User;

@Component("loginService")
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class LoginService {
	
	@Autowired
	private HDB hdb;

	/**
	 * 查询用户
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public User getUser(User user) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.phone='"+user.getPhone()+"' and u.password='"+CommonUtil.Md5(user.getPassword())+"'";
		List<User> list = (List<User>) hdb.findHql(hql);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	/**
	 * 修改登录时间
	 * @param user
	 */
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
	public void updateLastLoginTime(User user) {
		// TODO Auto-generated method stub
		user.setLastlogin(DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"));
		hdb.saveOrUpdate(user);
	}


}
