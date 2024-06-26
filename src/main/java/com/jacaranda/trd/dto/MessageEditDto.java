package com.jacaranda.trd.dto;

import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class MessageEditDto {
	
	private Integer idMessage;
	private String user;
	private String content;
	private Integer anonimous;
	private Integer spoiler;
	
	
	
	public MessageEditDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MessageEditDto(Integer idMessage, String user, String content, Integer anonimous,
			Integer spoiler) {
		super();
		this.idMessage = idMessage;
		this.user = user;
		this.content = content;
		this.anonimous = anonimous;
		this.spoiler = spoiler;
	}
	
	

	
	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
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

	@Override
	public int hashCode() {
		return Objects.hash(idMessage);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageEditDto other = (MessageEditDto) obj;
		return Objects.equals(idMessage, other.idMessage);
	}
	
	
}
