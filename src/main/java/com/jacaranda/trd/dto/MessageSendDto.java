package com.jacaranda.trd.dto;

import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class MessageSendDto {
	
	
	private String user;
	private String content;
	private Integer anonimous;
	private Integer spoiler;
	public MessageSendDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageSendDto(String user, String content, Integer anonimous, Integer spoiler) {
		super();
		this.user = user;
		this.content = content;
		this.anonimous = anonimous;
		this.spoiler = spoiler;
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
	public Integer getAnonimous() {
		return anonimous;
	}
	public void setAnonimous(Integer anonimous) {
		this.anonimous = anonimous;
	}
	public Integer getSpoiler() {
		return spoiler;
	}
	public void setSpoiler(Integer spoiler) {
		this.spoiler = spoiler;
	}
	
	
	
}