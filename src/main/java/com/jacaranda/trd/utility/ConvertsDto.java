package com.jacaranda.trd.utility;

import java.util.ArrayList;
import java.util.List;

import com.jacaranda.trd.dto.BookDto;
import com.jacaranda.trd.dto.LikeDto;
import com.jacaranda.trd.dto.MessageDto;
import com.jacaranda.trd.dto.UserDto;
import com.jacaranda.trd.model.Book;
import com.jacaranda.trd.model.Like;
import com.jacaranda.trd.model.Message;
import com.jacaranda.trd.model.UserLogin;



public class ConvertsDto {
	
	
	public static UserDto userToUserDto(UserLogin user) {
		return new UserDto(user.getUsername(), user.getPassword(), user.getRol(), user.getEmail());
	}
	
	public static List<UserDto> getListUserDto(List<UserLogin> users ){
		List<UserDto> userDto = new ArrayList<UserDto>();
		
		for(UserLogin m: users) {
			userDto.add(userToUserDto(m));
		}
		
		return userDto;
	}
	
	
	public static MessageDto messageToMessageDto(Message message) {
		return new MessageDto(message.getId(), message.getUsername().getUsername(), message.getContent(), message.getDate(), message.getStatus(), message.getIdBook().getId(), message.getSpoiler(), message.getAnonimous());
	}
	
	public static List<MessageDto> getListMessagesDto(List<Message> messages ){
		List<MessageDto> messageDto = new ArrayList<MessageDto>();
		
		for(Message m: messages) {
			messageDto.add(messageToMessageDto(m));
		}
		
		return messageDto;
	}
	
	
	public static BookDto bookToBookDto(Book book) {
		return new BookDto(book.getId(), book.getName(), book.getDescription(), book.getLink());
	}
	
	public static LikeDto likeToLikeDto(UserLogin user, Message message) {
		return new LikeDto(user.getUsername(), message.getId(), message.getContent());
	}
	
	public static List<LikeDto> getListLikeDto(List<Like> likeList ){
		List<LikeDto> messageDto = new ArrayList<LikeDto>();
		
		for(Like m: likeList) {
			messageDto.add(likeToLikeDto(m.getUser(), m.getMessage()));
		}
		
		return messageDto;
	}
	
	

}
