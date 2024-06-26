package com.jacaranda.trd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.trd.dto.BookDto;
import com.jacaranda.trd.exception.NotFound;
import com.jacaranda.trd.model.Book;
import com.jacaranda.trd.repository.BookRepository;
import com.jacaranda.trd.utility.ConvertsDto;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public BookDto findBook(String name) {
		Book book = bookRepository.findByName(name);
		if(book!=null) {
			return ConvertsDto.bookToBookDto(book);
		}else {
			throw new NotFound("Book name not found");
		}
	}

}
