package com.jacaranda.trd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.trd.model.Book;
import com.jacaranda.trd.model.Message;
import java.util.List;




public interface MessageRepository extends JpaRepository<Message, Integer>{
	
	List<Message> findByIdBook(Book idBook);

}
