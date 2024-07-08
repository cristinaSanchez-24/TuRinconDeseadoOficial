package com.jacaranda.trd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jacaranda.trd.dto.LikeAddDto;
import com.jacaranda.trd.dto.LikeDto;
import com.jacaranda.trd.exception.BadRequest;
import com.jacaranda.trd.exception.NotFound;
import com.jacaranda.trd.model.IdLike;
import com.jacaranda.trd.model.Like;
import com.jacaranda.trd.model.Message;
import com.jacaranda.trd.model.UserLogin;
import com.jacaranda.trd.repository.LikeRepository;
import com.jacaranda.trd.repository.MessageRepository;
import com.jacaranda.trd.repository.UserLoginRepository;
import com.jacaranda.trd.utility.ConvertsDto;

@Service
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private UserLoginRepository userRepository;
	@Autowired
	private MessageRepository messageRepository;
	
	
	public LikeDto addLike(LikeAddDto likeAdd) {
		UserLogin userFound = userRepository.findById(likeAdd.getUsername()).orElse(null);
		Message messageFound = messageRepository.findById(likeAdd.getIdMessage()).orElse(null);
		
		if(userFound!=null) {
			if(messageFound!=null) {
				Like like = new Like(userFound, messageFound);
				IdLike idLike = new IdLike(likeAdd.getUsername(), likeAdd.getIdMessage());
				Like likeFound = likeRepository.findById(idLike).orElse(null);
				if(likeFound==null) {
					Like addLike = likeRepository.save(like);
					if(addLike!=null) {
						return ConvertsDto.likeToLikeDto(userFound, messageFound);						
					}else {
						throw new BadRequest("Error al guardar el like");
					}
				}else {
					throw new BadRequest("Ya le diiste like a este mensaje");
				}
			}else {
				throw new NotFound("Message not found");
			}
		}else {
			throw new NotFound("User not found");
		}
	}
	
	public LikeDto deleteLike(String username, Integer idMessage) {
		UserLogin userFound = userRepository.findById(username).orElse(null);
		Message messageFound = messageRepository.findById(idMessage).orElse(null);
		
		if(userFound!=null) {
			if(messageFound!=null) {
				IdLike idLike = new IdLike(username, idMessage);
				Like likeFound = likeRepository.findById(idLike).orElse(null);
				if(likeFound!=null) {
					likeRepository.delete(likeFound);
					return ConvertsDto.likeToLikeDto(userFound, messageFound);						
				}else {
					throw new BadRequest("Ya le diiste like a este mensaje");
				}
			}else {
				throw new NotFound("Message not found");
			}
		}else {
			throw new NotFound("User not found");
		}
		
	}
	
	public List<LikeDto> existLike(String username) {
		UserLogin userFound = userRepository.findById(username).orElse(null);
		
		if(userFound!=null) {
				List<Like> likeFound = likeRepository.findByUser(userFound);
				List<LikeDto> listLike = new ArrayList<LikeDto>();
				if(likeFound.size()>0) {
					listLike = ConvertsDto.getListLikeDto(likeFound);
				}
				return listLike;						
		}else {
			throw new NotFound("User not found");
		}
	}
	
	public List<LikeDto> totalLike(Integer id) {
		Message message = messageRepository.findById(id).orElse(null);
		if(message!=null) {
				List<Like> likeFound = likeRepository.findByMessage(message);
				List<LikeDto> listLike = new ArrayList<LikeDto>();
				if(likeFound.size()>0) {
					listLike = ConvertsDto.getListLikeDto(likeFound);
				}
				return listLike;						
		}else {
			throw new NotFound("User not found");
		}
	}
	
	
}
