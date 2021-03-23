package com.surveysparrow.dto;

public class AddUrlRequest {

	private String url;
	private int responseTime;
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
	
	public AddUrlRequest() {}
	
	public AddUrlRequest(String url, int responseTime) {
		super();
		this.url = url;
		this.responseTime = responseTime;
	}
	
	
}
