package com.marck.in.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.marck.common.BaseAction;
import com.marck.common.CommonUtil;
import com.marck.common.model.User;
import com.marck.common.model.UserMessage;
import com.marck.in.service.GeneralService;

@Component("generalAction")
@Scope("prototype")
public class GeneralAction extends BaseAction {

	@Autowired
	private GeneralService generalService;
	
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	private User user;
	private UserMessage userMessage;
	private Integer pageNo;
	private Integer pageNum;
	
	/**
	 * 签到
	 */
	public String signin(){
		try {
			
			if( user == null || CommonUtil.validParams(user.getId()) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.signin(user,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询评论列表异常",e);
			map.put("msg", "查询异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 用户反馈
	 * @return
	 */
	public String sendMessage(){
		try {
			
			if( userMessage == null || CommonUtil.validParams(userMessage.getUserId(),userMessage.getMessage()) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.sendMessage(userMessage,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送信息异常",e);
			map.put("msg", "发送信息异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}

	/**
	 * 查询区域
	 * @return
	 */
	public String selUserList(){
		try {
			
			if( CommonUtil.validParams(request.getParameter("type")) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			Integer type = Integer.parseInt(request.getParameter("type"));
			String time = request.getParameter("time");
			
			generalService.selUserList(type,time,pageNo,pageNum,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询列表异常",e);
			map.put("msg", "查询列表异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	
	public Integer getPageNo() {
		return pageNo;
	
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageNum() {
		return pageNum;
	
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Map<String, Object> getMap() {
		return map;//null == map?"":map;
	
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public User getUser() {
		return user;
	
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserMessage getUserMessage() {
		return userMessage;
	
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}

}
