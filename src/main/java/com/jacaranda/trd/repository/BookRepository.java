package com.jacaranda.trd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.trd.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{

	Book findByName(String name);

}
