package com.jacaranda.trd.exception;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalControllerError {
/*Clase para manejar las excepciones*/



	@ExceptionHandler(NotFound.class)
	public ResponseEntity<ApiError>handleElementNotFoundException(NotFound e){
	ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,e.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);

	}
	
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<ApiError>handleElementBadRequestException(BadRequest e){
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,e.getMessage());
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);

	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiError>handleException(BadRequestException e){
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError>handleException(Exception e){
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,e.getMessage());
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);

	}
	
	
	



}


