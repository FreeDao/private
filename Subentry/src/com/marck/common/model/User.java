package com.marck.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String phone = "";
	@Column
	private String password = "";
	@Column
	private String lastlogin = "";
	@Column
	private Integer integral = 0;
	@Column
	private Integer succession = 0;
	@Column
	private Integer signin = 0;
	@Column
	private String birthday = "";
	@Column
	private String lastsignin = "";
	@Transient
	private String captcha = "";
	
	public Integer getId() {
		return null == id ? 0 : id;
	
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return null == phone ? "" : phone;
	
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return null == password ? "" : password;
	
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastlogin() {
		return null == lastlogin ? "" : lastlogin;
	
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	public Integer getIntegral() {
		return null == integral ? 0 : integral;
	
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Integer getSuccession() {
		return null == succession ? 0 : succession;
	
	}
	public void setSuccession(Integer succession) {
		this.succession = succession;
	}
	public String getBirthday() {
		return null == birthday ? "" : birthday;
	
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCaptcha() {
		return null == captcha ? "" : captcha;
	
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public Integer getSignin() {
		return null == signin ? 0 : signin;
	
	}
	public void setSignin(Integer signin) {
		this.signin = signin;
	}
	public String getLastsignin() {
		return null == lastsignin ? "" : lastsignin;
	
	}
	public void setLastsignin(String lastsignin) {
		this.lastsignin = lastsignin;
	}
	
	
}
