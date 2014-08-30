package com.marck.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usermessage")
public class UserMessage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String message;
	@Column
	private Integer userId;
	@Column
	private String addTime;
	@Transient
	private String phone;
	
	public UserMessage(){
		
	}
	
	public UserMessage(Integer id, String message, Integer userId,
			String addTime, String phone) {
		super();
		this.id = id;
		this.message = message;
		this.userId = userId;
		this.addTime = addTime;
		this.phone = phone;
	}
	public String getPhone() {
		return null == phone ? "" : phone;
	
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddTime() {
		return null == addTime ? "" : addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public Integer getId() {
		return null == id ? 0 : id;
	
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return null == message ? "" : message;
	
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getUserId() {
		return null == userId ? 0 : userId;
	
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
