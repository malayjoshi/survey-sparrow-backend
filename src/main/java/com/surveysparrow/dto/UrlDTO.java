package com.surveysparrow.dto;

public class UrlDTO {
	
	private int id;
	private String url;
	private int responseTime;
	
	public UrlDTO() {}
	
	public UrlDTO(int id, String url, int responseTime) {
		super();
		this.id = id;
		this.url = url;
		this.responseTime = responseTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}
	
	
	
}
