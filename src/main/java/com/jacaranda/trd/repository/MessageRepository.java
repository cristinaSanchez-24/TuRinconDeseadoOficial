package com.jacaranda.trd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.trd.model.Message;



public interface MessageRepository extends JpaRepository<Message, Integer>{

}
