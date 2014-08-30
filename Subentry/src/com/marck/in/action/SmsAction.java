package com.marck.in.action;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.marck.common.BaseAction;
import com.marck.common.CommonUtil;
import com.marck.common.Send;
import com.marck.common.SystemArguments;
import com.marck.common.model.User;
import com.marck.in.service.RegisterService;
import com.marck.in.service.SmsService;

@Component("smsAction")
@Scope("prototype")
public class SmsAction extends BaseAction{

	@Autowired
	private RegisterService registerService;
	@Autowired
	private SmsService smsService;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	private String phone;
	private String captcha;
	
	/**
	 * 获取验证码
	 * @return
	 */
	public String get(){
		try {
			String content = "";
			
			if(CommonUtil.validParams(phone)){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			int temp = (int) (Math.random()*100000+10000);
			
			String captcha = temp+"";
			
			User user = registerService.checkUser(phone);
			
			if( null != user ){
				map.put("msg", "该手机已经注册");
				map.put("code", 0);
				return SUCCESS;
			}
			
			content="您的验证码是："+captcha+"。如需帮助请联系客服。";
			
			System.out.println(Send.SMS("account=474550644&password=tangwei&mobile="+phone+"&content="+URLEncoder.encode(content, "UTF-8"),"http://sms.106jiekou.com/utf8/sms.aspx"));
			
			smsService.saveCaptcha(phone,captcha);
			
			map.put("msg", "获取验证成功");
			map.put("code", 1);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("获取验证码异常",e);
			map.put("msg", "获取验证码异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 验证是否有效
	 * @return
	 */
	public String valid(){
		try {
			
			if(CommonUtil.validParams(phone,captcha)){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			 if(captcha.equals(SystemArguments.captcha)){
				map.put("msg", "你爸妈造你在作弊吗？");
				map.put("code", 1);
				return SUCCESS;
			 }
			
			smsService.checkCaptcha(phone, captcha, map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("验证码验证异常",e);
			map.put("msg", "验证码验证异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}

	public Map<String, Object> getMap() {
		return map;
	
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getPhone() {
		return phone;
	
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCaptcha() {
		return captcha;
	
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	
	
}
