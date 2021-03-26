package com.surveysparrow.dto;

import java.util.Date;

public class LogDTO {
	
	private int id;
	private String message;
	private Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public LogDTO(int id, String message, Date time) {
		super();
		this.id = id;
		this.message = message;
		this.time = time;
	}
	
	public LogDTO() {}
	
}
