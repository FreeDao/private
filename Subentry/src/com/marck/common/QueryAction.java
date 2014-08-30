package com.marck.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.marck.common.dao.HDB;
import com.marck.common.model.User;

@Component("queryAction")
@Scope("prototype")
public class QueryAction extends BaseAction{

	private PageUtil pu;
	private Integer pageNow;
	private Integer limit;
	
	private String queryValue;
	
	@Autowired
	private QueryService queryService;
	
	public String login(){
		try {
			String password = request.getParameter("password");
			
			Boolean	isLogin = false;
			if( null == password ){
				isLogin = true;
			}
			
			//Boolean isLogin = (Boolean) request.getSession().getAttribute("isLogin");
			
			Boolean isPass = queryService.checkPassword(password);
			
			if( isPass || isLogin  ){
				
				pu = queryService.findPageUtil(queryValue,pageNow,limit);
				
				String resUrl = request.getRequestURI();
				request.getSession().setAttribute("url", resUrl.substring(resUrl.indexOf("/",1)+1)+"?");
				request.getSession().setAttribute("isLogin", true);
				return "loginSuccess";
			}else{
				request.setAttribute("msg", "密码不正确");
				return "loginFail";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "loginFail";
	}
	
	
	public PageUtil getPu() {
		return pu;
	
	}

	public void setPu(PageUtil pu) {
		this.pu = pu;
	}

	public Integer getPageNow() {
		return pageNow;
	
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getLimit() {
		return limit;
	
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getQueryValue() {
		return queryValue;
	
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}
	
	
	
	
}
