package com.marck.in.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marck.common.CommonUtil;
import com.marck.common.DateUtil;
import com.marck.common.dao.HDB;
import com.marck.common.model.User;
import com.marck.common.model.UserIp;

@Component("loginService")
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class LoginService {
	
	@Autowired
	private HDB hdb;

	/**
	 * 查询用户
	 * @param map 
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public User getUser(User user, Map<String, Object> map) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.phone='"+user.getPhone()+"' and u.password='"+CommonUtil.Md5(user.getPassword())+"'";
		User u =  (User) hdb.findUniqueHql(hql);
		if( null != u ){
			if(CommonUtil.validParams(u.getSerialnum(),u.getIeme())){
				u.setType(CommonUtil.changeIos8859ToUtf8(user.getType()));
				u.setSerialnum(user.getSerialnum());
				u.setIeme(user.getIeme());
				hdb.saveOrUpdate(u);
			}/*else if(!u.getSerialnum().equals(user.getSerialnum())){
				map.put("msg", "你的账号已经绑定在其他设备上");
				map.put("code", 0);
				return null;
			}*/
			u.setIsJaiBreak(user.getIsJaiBreak());
		}else{
			map.put("msg", "帐号或密码不正确");
			map.put("code", 0);
		}
		return u;
	}

	/**
	 * 修改登录时间
	 * @param user
	 */
	public void updateLastLoginTime(User user) {
		// TODO Auto-generated method stub
		user.setLastlogin(DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"));
		hdb.saveOrUpdate(user);
		UserIp ui = new UserIp();
		ui.setAddTime(DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"));
		ui.setIp(user.getIp());
		ui.setUserId(user.getId());
		try {
			URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip="+user.getIp());
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			InputStreamReader input = new InputStreamReader(huc.getInputStream(),"utf-8");
            Scanner inputStream = new Scanner(input);   
            StringBuffer sb = new StringBuffer();
            while (inputStream.hasNext()) {    
                 sb.append(inputStream.nextLine());
            }
            JSONObject jsonObj = JSONObject.fromObject(sb.toString());
			
            String province = jsonObj.getJSONObject("data").getString("region");
            String city = jsonObj.getJSONObject("data").getString("city");
            
            ui.setAddress(province+city);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hdb.saveOrUpdate(ui);
		/*String hql ="from UserIp ui where ui.userId ="+user.getId()+" order by ui.addTime desc";
		List<UserIp> uis = (List<UserIp>) hdb.findHql(hql);
		for(UserIp userip : uis){
			if(userip.getAddTime().substring(0, 10).equals(DateUtil.getNowString("yyyy-MM-dd"))){
				return;
			}else{
				hdb.delete(userip);
			}
		}*/
			
	}


}
