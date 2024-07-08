package com.jacaranda.trd.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.trd.dto.MessageDto;
import com.jacaranda.trd.dto.MessageEditDto;
import com.jacaranda.trd.dto.MessageSendDto;
import com.jacaranda.trd.exception.BadRequest;
import com.jacaranda.trd.exception.NotFound;
import com.jacaranda.trd.model.Book;
import com.jacaranda.trd.model.Message;
import com.jacaranda.trd.model.UserLogin;
import com.jacaranda.trd.repository.BookRepository;
import com.jacaranda.trd.repository.MessageRepository;
import com.jacaranda.trd.repository.UserLoginRepository;
import com.jacaranda.trd.utility.ConvertsDto;

@Service
public class MessageServices {
/*Servicio para los mensajes de la base de datos*/
	
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UserLoginRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private LikeService likeService;
	
	
	/**
	 * Metodo para traer todos los mensajes de la base de datos
	 * @return una lista de json con mensajes dto
	 */
	public List<MessageDto> getMessages(Integer id){
		Book book = bookRepository.findById(id).orElse(null);
		if(book!=null) {
			List<MessageDto> message = ConvertsDto.getListMessagesDto(messageRepository.findByIdBook(book));
			for(MessageDto m: message) {
				m.setTotalLike(likeService.totalLike(m.getIdMessage()).size());
			}
			return message;		
		}else {
			throw new NotFound("Book Not founs");
		}
	}
	
	/**
	 * Metodo para guardar un mensaje en la base de datos. 
	 * @param message
	 * @return el mensaje que se guardo. Error 404: Cuando el usuario no se ha encontrado
	 */
	public MessageDto addMessage(MessageSendDto message) {
		UserLogin user = userRepository.findById(message.getUser()).orElse(null);
		if(user!=null) {
			Book book = bookRepository.findById(message.getIdBook()).orElse(null);
			if(book!=null) {
				Message newMessage = new Message(0, message.getContent(), Date.valueOf(LocalDate.now()), user, "active", message.getAnonimous(), message.getSpoiler(), book);
				newMessage.setStatus("active");
				Message saveMessage = messageRepository.save(newMessage);
				return ConvertsDto.messageToMessageDto(saveMessage);				
			}else {
				throw new NotFound("Book not found");
			}
		}else {
			throw new NotFound("User not found");
		}
	}
	
	/**
	 * Metodo para poder borrar un mensaje, cambiando su estado a borrado en vez de borrarlo de la base de datos
	 * @param idMessage
	 * @return json con el mensaje borrado. Error 404: Si el mensaje no existe
	 */
	public MessageDto deleteMessage(Integer idMessage) {
		Message message = messageRepository.findById(idMessage).orElse(null);
		if(message!=null) {
			message.setStatus("delete");
			Message messageEdit = messageRepository.save(message);
			return ConvertsDto.messageToMessageDto(messageEdit);
		}else {
			throw new NotFound("Message not found");
		}
	}
	
	
	/**
	 * Metodo para editar un mensaje ademas cambiando su estado a editado para poder identificarlo
	 * @param idMessage
	 * @param message
	 * @return json con el mensaje editado. Error 404: Si el mensaje no se encontro, o el usuario no se encontri
	 * Error 400: Si el id de la url y el objeto no coinciden
	 */
	public MessageDto editMessage(Integer idMessage, MessageEditDto message) {
		
			Message messageFound = messageRepository.findById(idMessage).orElse(null);
			if(messageFound!=null) {
				if(!messageFound.getStatus().equals("delete")) {
					UserLogin user = userRepository.findById(message.getUser()).orElse(null);
					if(user!=null) {
						if(messageFound.getUsername().getUsername().equals(user.getUsername())) {
							Message messageEdit = new Message(messageFound.getId(), message.getContent(), messageFound.getDate(), user, messageFound.getStatus(), message.getAnonimous(), message.getSpoiler(), messageFound.getIdBook());
							messageEdit.setStatus("edit");
							Message messageSave = messageRepository.save(messageEdit);
							return ConvertsDto.messageToMessageDto(messageSave);
							
						}else {
							throw new BadRequest("User cant change"); 
						}
					}else {
						throw new NotFound("User not found");
					}
					
				}else {
					throw new BadRequest("Cant edit a delete message");
				}
			}else {
				throw new NotFound("Message not Found");
			}
	}
	
}
