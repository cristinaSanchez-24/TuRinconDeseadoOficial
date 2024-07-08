package com.jacaranda.trd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.trd.dto.LikeAddDto;
import com.jacaranda.trd.dto.LikeDto;
import com.jacaranda.trd.service.LikeService;


@RestController
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/addLike")
	public ResponseEntity<?> addLike(@RequestBody LikeAddDto like){
		LikeDto likeDto = likeService.addLike(like);
		return ResponseEntity.ok(likeDto);
	}
	
	@DeleteMapping("/deleteLike/{id}")
	public ResponseEntity<?> deleteLike(@RequestParam("username") String user, @PathVariable Integer id){
		LikeDto like = likeService.deleteLike(user, id);
		return ResponseEntity.ok(like);
	}
	
	@GetMapping("/gesLikes/{username}")
	public ResponseEntity<?> existLike(@PathVariable String username){
		List<LikeDto> list = likeService.existLike(username);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getTotalLikes/{id}")
	public ResponseEntity<?> totalLike(@PathVariable Integer id){
		List<LikeDto> list = likeService.totalLike(id);
		return ResponseEntity.ok(list);
	}

}
