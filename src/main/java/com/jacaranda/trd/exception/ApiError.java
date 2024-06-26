package com.jacaranda.trd.exception;
import java.time.LocalDateTime;

import java.util.Objects;



import org.springframework.http.HttpStatus;



import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;



public class ApiError {
	/*Clase para customizar las excepciones*/

	private HttpStatus status;

	@JsonFormat(shape= Shape.STRING, pattern ="dd/MM/yyyy hh:mm:ss")
	private LocalDateTime date;
	private String message;
	
	public ApiError() {
		date = LocalDateTime.now();
	}


	public ApiError(HttpStatus status, String message) {
		super();
		this.status = status;
		this.date = LocalDateTime.now();
		this.message = message;

	}



	public HttpStatus getStatus() {

		return status;

	}



	public void setStatus(HttpStatus status) {

		this.status = status;

	}



	public LocalDateTime getDate() {

		return date;

	}



	public void setDate(LocalDateTime date) {

		this.date = date;

	}



	public String getMessage() {

		return message;

	}



	public void setMessage(String message) {

		this.message = message;

	}



	@Override

	public int hashCode() {

		return Objects.hash(date, message, status);

	}



	@Override

	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		ApiError other = (ApiError) obj;

		return Objects.equals(date, other.date) && Objects.equals(message, other.message) && status == other.status;

	}
}
