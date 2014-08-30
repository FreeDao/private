package com.marck.common.model;

public class UserIntergralQuery {

	private Integer platform;
	private Double total;
	private String name;
	
	public String getName() {
		switch (platform) {
		case 1:
			return "多盟";
		case 2:
			return "有米";
		case 3:
			return "力美";
		case 4:
			return "点入";
		default:
			return "未知";
		}
	
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPlatform() {
		return null == platform ? 0 : platform;
	
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	public Double getTotal() {
		return null == total ? 0 : total;
	
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	
	
}
