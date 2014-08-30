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
	private String recommend = "";
	@Column
	private Integer pid = 0;
	@Column
	private String lastsign = "";
	@Transient
	private List<UserIntergralQuery> userIntergralQueries;
	@Transient
	private Double tj;
	@Transient
	private Double md;
	@Transient
	private Double ym;
	@Transient
	private Double mp;
	@Transient
	private Double dr;
	@Transient
	private Double lm;
	@Transient
	private Double kg;

	public String getLastsign() {
		return null == lastsign ? "" : lastsign;
	
	}
	public void setLastsign(String lastsign) {
		this.lastsign = lastsign;
	}
	public Integer getPid() {
		return null == pid ? 0 : pid;
	
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Double getKg() {
		return null == kg ? 0 : kg;
	
	}
	public void setKg(Double kg) {
		this.kg = kg;
	}
	public Double getLm() {
		return null == lm ? 0 : lm;
	
	}
	public void setLm(Double lm) {
		this.lm = lm;
	}
	public Double getTj() {
		return null == tj ? 0 : tj;
	
	}
	public void setTj(Double tj) {
		this.tj = tj;
	}
	public Double getYm() {
		return null == ym ? 0 : ym;
	
	}
	public void setYm(Double ym) {
		this.ym = ym;
	}
	public Double getDr() {
		return null == dr ? 0 : dr;
	
	}
	public void setDr(Double dr) {
		this.dr = dr;
	}
	public String getRecommend() {
		return null == recommend ? "" : recommend;
	
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getIp() {
		return null == ip ? "" : ip;
	
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Double getMp() {
		return null == mp ? 0 : mp;
	
	}
	public void setMp(Double mp) {
		this.mp = mp;
	}
	public Double getMd() {
		return null == md ? 0 : md;
	
	}
	public void setMd(Double md) {
		this.md = md;
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
