package com.jacaranda.trd.dto;

public class ChatMessageDto {
	
	String message;
	String user;
	public ChatMessageDto() {
		super();
	}
	public ChatMessageDto(String message, String user) {
		super();
		this.message = message;
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	

}
