package com.jacaranda.trd.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="like_table")
@IdClass(IdLike.class)
public class Like {

	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private UserLogin user;
	@Id
	@ManyToOne
	@JoinColumn(name = "message")
	private Message message;
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(UserLogin user, Message message) {
		super();
		this.user = user;
		this.message = message;
	}
	public UserLogin getUser() {
		return user;
	}
	public void setUser(UserLogin user) {
		this.user = user;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
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
		Like other = (Like) obj;
		return Objects.equals(message, other.message) && Objects.equals(user, other.user);
	}
	
	
	
}
