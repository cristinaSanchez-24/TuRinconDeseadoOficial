package com.jacaranda.trd.dto;

public class LikeAddDto {
	
	private String username;
	private Integer idMessage;
	public LikeAddDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LikeAddDto(String username, Integer idMessage) {
		super();
		this.username = username;
		this.idMessage = idMessage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}
	
	

}
