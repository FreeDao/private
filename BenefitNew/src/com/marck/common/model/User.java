package com.marck.common.model;

import java.util.List;

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
	private Integer integral = 0;
	@Column
	private String lastlogin = "";
	@Column
	private String ip = "";
	@Column
	private String type = "";
	@Column
	private String serialnum = "";
	@Column
	private String ieme = "";
	@Column
	private Integer isJaiBreak = 0;
	@Transient
	private List<UserIntergralQuery> userIntergralQueries;
	@Transient
	private Double dm;
	@Transient
	private Double dr;
	@Transient
	private Double lm;
	@Transient
	private Double ym;
	
	public Double getLm() {
		return null == lm ? 0 : lm;
	
	}
	public void setLm(Double lm) {
		this.lm = lm;
	}
	public Double getYm() {
		return null == ym ? 0 : ym;
	
	}
	public void setYm(Double ym) {
		this.ym = ym;
	}
	public Integer getIsJaiBreak() {
		return null == isJaiBreak ? 0 : isJaiBreak;
	
	}
	public void setIsJaiBreak(Integer isJaiBreak) {
		this.isJaiBreak = isJaiBreak;
	}
	public Double getDr() {
		return null == dr ? 0 : dr;
	
	}
	public void setDr(Double dr) {
		this.dr = dr;
	}
	public String getType() {
		return null == type ? "" : type;
	
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSerialnum() {
		return null == serialnum ? "" : serialnum;
	
	}
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}
	public String getIeme() {
		return null == ieme ? "" : ieme;
	
	}
	public void setIeme(String ieme) {
		this.ieme = ieme;
	}
	public String getIp() {
		return null == ip ? "" : ip;
	
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Double getDm() {
		return null == dm ? 0 : dm;
	
	}
	public void setDm(Double dm) {
		this.dm = dm;
	}
	public List<UserIntergralQuery> getUserIntergralQueries() {
		return userIntergralQueries;
	
	}
	public void setUserIntergralQueries(
			List<UserIntergralQuery> userIntergralQueries) {
		this.userIntergralQueries = userIntergralQueries;
	}
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
	public Integer getIntegral() {
		return null == integral ? 0 : integral;
	
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public String getLastlogin() {
		return null == lastlogin ? "" : lastlogin;
	
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	
}
