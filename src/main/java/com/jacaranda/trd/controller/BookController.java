package com.jacaranda.trd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.trd.dto.BookDto;
import com.jacaranda.trd.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/foundBook")
	public ResponseEntity<?> foundBookByName(@RequestParam("name") String name){
		BookDto book = bookService.findBook(name);
		return ResponseEntity.ok(book);
	}
	
}
