package com.jacaranda.trd.dto;

public class LikeDto {

	private String username;
	private Integer idMessage;
	private String content;
	private Integer totalLikes;
	public LikeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LikeDto(String username, Integer idMessage, String content) {
		super();
		this.username = username;
		this.idMessage = idMessage;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
