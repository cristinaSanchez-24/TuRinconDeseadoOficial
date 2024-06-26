package com.jacaranda.trd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.trd.model.UserLogin;


public interface UserLoginRepository extends JpaRepository<UserLogin, String>{

	List<UserLogin> findByEmail(String email);

}
