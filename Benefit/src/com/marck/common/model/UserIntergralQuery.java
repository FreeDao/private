package com.marck.common.model;

public class UserIntergralQuery {

	private Integer platform;
	private Double total;
	private String name;
	
	public String getName() {
		switch (platform) {
		case 1:
			return "巨朋";
		case 5:
			return "点乐";
		case 2:
			return "迷迪";
		case 6:
			return "触控";
		case 3:
			return "磨盘";
		case 7:
			return "点入";
		case 8:
			return "行云";
		case 4:
			return "果盟";
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
