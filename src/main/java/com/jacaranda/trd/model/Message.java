package com.jacaranda.trd.model;

import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String content;
	@JsonFormat(shape= Shape.STRING, pattern ="dd/MM/yyyy HH:mm:SS")
	private Date date;
	@ManyToOne
	@JoinColumn(name="username")
	private UserLogin username;
	private String status;
	private Integer anonimous;
	private Integer spoiler;
	@ManyToOne
	@JoinColumn(name = "idBook")
	private Book idBook;
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(Integer id, String content, Date date, UserLogin username, String status, Integer anonimous,
			Integer spoiler, Book idBook) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.username = username;
		this.status = status;
		this.anonimous = anonimous;
		this.spoiler = spoiler;
		this.idBook = idBook;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public UserLogin getUsername() {
		return username;
	}
	public void setUsername(UserLogin username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	
	
	public Book getIdBook() {
		return idBook;
	}
	public void setIdBook(Book idBook) {
		this.idBook = idBook;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(id, other.id);
	}
	
	
	


}
