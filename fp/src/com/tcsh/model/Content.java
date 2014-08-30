package com.tcsh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="content")
public class Content {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String rule;
	@Column
	private Date starTime;
	@Column
	private Date endTime;
	@Column
	private String tip;
	@Column
	private Integer type;
	@Column
	private Integer time;
	@Column
	private Integer addTime;
	
	public Integer getAddTime() {
		return addTime;
	}
	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public Date getStarTime() {
		return starTime;
	}
	public void setStarTime(Date starTime) {
		this.starTime = starTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}

	
}
