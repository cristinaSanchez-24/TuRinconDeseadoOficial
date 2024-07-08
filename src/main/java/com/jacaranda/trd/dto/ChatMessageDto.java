package com.jacaranda.trd.dto;

public class ChatMessageDto {
	    
	private Integer id;
	private String user;
	 private String content;
	 private String status;
	 private Integer spoiler;
	 private Integer anonimous;
	public ChatMessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatMessageDto(Integer id,String user, String content, String status, Integer spoiler, Integer anonimous) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.status = status;
		this.spoiler = spoiler;
		this.anonimous = anonimous;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSpoiler() {
		return spoiler;
	}
	public void setSpoiler(Integer spoiler) {
		this.spoiler = spoiler;
	}
	public Integer getAnonimous() {
		return anonimous;
	}
	public void setAnonimous(Integer anonimous) {
		this.anonimous = anonimous;
	}
	
	
	
	

}
