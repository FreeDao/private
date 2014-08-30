package com.marck.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="apply")
public class Apply {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private Integer num;
	@Column
	private String alipay;
	@Column
	private Integer userId;
	@Column
	private String addTime;
	@Column
	private String name;
	@Column
	private Integer status;
	@Column
	private String phone;
	@Transient
	private String account;
	@Transient
	private Integer integral;
	
	public Apply(){
	}
	
	public Apply(Integer id, Integer num, String alipay, Integer userId,
			String addTime, String name, Integer status, String phone) {
		this.id = id;
		this.num = num;
		this.alipay = alipay;
		this.userId = userId;
		this.addTime = addTime;
		this.name = name;
		this.status = status;
		this.phone = phone;
	}
	
	
	public String getAccount() {
		return null == account ? "" : account;
	
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getIntegral() {
		return null == integral ? 0 : integral;
	
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getPhone() {
		return null == phone ? "" : phone;
	
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getStatus() {
		return null == status ? 0 : status;
	
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getNum() {
		return null == num ? 0 : num;
	
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getId() {
		return null == id ? 0 : id;
	
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAlipay() {
		return null == alipay ? "" : alipay;
	
	}
	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	public Integer getUserId() {
		return null == userId ? 0 : userId;
	
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAddTime() {
		return null == addTime ? "" : addTime;
	
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getName() {
		return null == name ? "" : name;
	
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
