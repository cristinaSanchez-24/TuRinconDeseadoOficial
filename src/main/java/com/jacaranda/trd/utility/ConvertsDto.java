package com.jacaranda.trd.utility;

import java.util.ArrayList;
import java.util.List;

import com.jacaranda.trd.dto.BookDto;
import com.jacaranda.trd.dto.MessageDto;
import com.jacaranda.trd.dto.UserDto;
import com.jacaranda.trd.model.Book;
import com.jacaranda.trd.model.Message;
import com.jacaranda.trd.model.UserLogin;



public class ConvertsDto {
	
	
	public static UserDto userToUserDto(UserLogin user) {
		return new UserDto(user.getUsername(), user.getPassword(), user.getRol(), user.getEmail());
	}
	
	
	public static MessageDto messageToMessageDto(Message message) {
		return new MessageDto(message.getId(), message.getUsername().getUsername(), message.getContent(), message.getDate(), message.getStatus());
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

}
