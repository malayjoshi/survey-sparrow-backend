package com.surveysparrow.dto;

import java.util.Date;

public class PingResponseDTO {
	private boolean withinResponseTime;
	private Date time;
	public boolean isWithinResponseTime() {
		return withinResponseTime;
	}
	public void setWithinResponseTime(boolean withinResponseTime) {
		this.withinResponseTime = withinResponseTime;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public PingResponseDTO(boolean withinResponseTime, Date time) {
		super();
		this.withinResponseTime = withinResponseTime;
		this.time = time;
	}
	
	public PingResponseDTO() {}
	
}
