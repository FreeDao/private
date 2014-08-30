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
	private Double jp;
	@Transient
	private Double dl;
	@Transient
	private Double md;
	@Transient
	private Double dm;
	@Transient
	private Double mp;
	@Transient
	private Double dr;
	@Transient
	private Double ck;
	@Transient
	private Double xy;
	@Transient
	private Double gm;
	
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
	public Double getCk() {
		return null == ck ? 0 : ck;
	
	}
	public void setCk(Double ck) {
		this.ck = ck;
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
	public Double getXy() {
		return null == xy ? 0 : xy;
	
	}
	public void setXy(Double xy) {
		this.xy = xy;
	}
	public Double getGm() {
		return null == gm ? 0 : gm;
	
	}
	public void setGm(Double gm) {
		this.gm = gm;
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
	public Double getJp() {
		return null == jp ? 0 : jp;
	
	}
	public void setJp(Double jp) {
		this.jp = jp;
	}
	public Double getDl() {
		return null == dl ? 0 : dl;
	
	}
	public void setDl(Double dl) {
		this.dl = dl;
	}
	public Double getMd() {
		return null == md ? 0 : md;
	
	}
	public void setMd(Double md) {
		this.md = md;
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
