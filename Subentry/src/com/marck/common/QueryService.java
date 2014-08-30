package com.marck.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marck.common.dao.HDB;
import com.marck.common.model.User;

@Component("queryService")
@Transactional(readOnly = true,propagation=Propagation.REQUIRED)
public class QueryService {

	@Autowired
	private HDB hdb;
	
	public Boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		try {
			String hql = "from User u where u.phone ='admin'";
			List<User> users = (List<User>) hdb.findHql(hql);
			if(users.size() > 0){
				if( users.get(0).getPassword().equals(CommonUtil.Md5(password))){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * 查询用户信息
	 * @param queryValue
	 * @param pageNow
	 * @param limit
	 * @return
	 */
	public PageUtil findPageUtil(String queryValue, Integer pageNow,
			Integer limit) {
		// TODO Auto-generated method stub
		String hql = "select new UserMessage(um.id,um.message,um.userId,um.addTime,u.phone) from User u,UserMessage um where u.id = um.userId ";
		if(!CommonUtil.validParams(queryValue)){
			hql += " and ( u.phone like '%"+queryValue+"%' or um.addTime like '%"+queryValue+"%' or um.userId like '%"+queryValue+"%' or um.message like '%"+queryValue+"%')";
		}
		
		return hdb.findHql(hql, pageNow, limit);
	}

}
