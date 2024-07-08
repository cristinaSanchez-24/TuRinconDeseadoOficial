package com.jacaranda.trd.model;

import java.util.Objects;

public class IdLike {

	private String user;
	private Integer message;
	public IdLike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IdLike(String user, Integer message) {
		super();
		this.user = user;
		this.message = message;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Integer getMessage() {
		return message;
	}
	public void setMessage(Integer message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		return Objects.hash(message, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdLike other = (IdLike) obj;
		return Objects.equals(message, other.message) && Objects.equals(user, other.user);
	}
	
	
	
	
}
