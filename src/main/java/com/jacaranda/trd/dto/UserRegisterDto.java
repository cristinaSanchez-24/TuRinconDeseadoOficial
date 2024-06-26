package com.jacaranda.trd.dto;

import java.util.Objects;

public class UserRegisterDto {

	private String username;
	private String password;
	private String email;
	public UserRegisterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegisterDto(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRegisterDto other = (UserRegisterDto) obj;
		return Objects.equals(username, other.username);
	}
	
	
}
