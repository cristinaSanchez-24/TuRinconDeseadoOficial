package com.jacaranda.trd.dto;

import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class MessageDto {
	
	private Integer idMessage;
	private String user;
	private String content;
	@JsonFormat(shape= Shape.STRING, pattern ="dd/MM/yyyy HH:mm")
	private Date date;
	private String status;
	private Integer idBook;
	private Integer spoiler;
	private Integer anonimous;
	private Integer totalLike;
	
	public MessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageDto(Integer idMessage, String user, String content, Date date, String status, Integer idBook, Integer spoiler, Integer anonimous) {
		super();
		this.idMessage = idMessage;
		this.user = user;
		this.content = content;
		this.date = date;
		this.status = status;
		this.idBook = idBook;
		this.spoiler = spoiler;
		this.anonimous = anonimous;
	}
	
	
	
	public Integer getTotalLike() {
		return totalLike;
	}
	public void setTotalLike(Integer totalLike) {
		this.totalLike = totalLike;
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
	public Integer getIdBook() {
		return idBook;
	}
	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
		MessageDto other = (MessageDto) obj;
		return Objects.equals(idMessage, other.idMessage);
	}
	
	

}
