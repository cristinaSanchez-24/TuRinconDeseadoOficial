package com.jacaranda.trd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.trd.model.IdLike;
import com.jacaranda.trd.model.Like;
import com.jacaranda.trd.model.UserLogin;
import java.util.List;
import com.jacaranda.trd.model.Message;



public interface LikeRepository extends JpaRepository<Like, IdLike>{

	
	List<Like> findByUser(UserLogin user);
	
	List<Like> findByMessage(Message message);
}
