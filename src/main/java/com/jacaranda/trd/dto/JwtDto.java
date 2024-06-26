package com.jacaranda.trd.dto;

import java.util.Objects;

public class JwtDto {
	
	private String token;

	public JwtDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtDto(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		return Objects.hash(token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JwtDto other = (JwtDto) obj;
		return Objects.equals(token, other.token);
	}
	
	
	

}
