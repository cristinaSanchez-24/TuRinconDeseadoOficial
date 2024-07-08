package com.jacaranda.trd.controller;

import java.util.Observable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.jacaranda.trd.dto.ChatMessageDto;
import com.jacaranda.trd.dto.MessageDto;
import com.jacaranda.trd.dto.MessageEditDto;
import com.jacaranda.trd.dto.MessageSendDto;
import com.jacaranda.trd.service.MessageServices;

@Controller
public class WebSocketController {
/*Controlador para el socket*/
	
	@Autowired
	private MessageServices messageService;

	/**
	 * Metodo para poder rescatar el mensaje que nos enviar desde el fronted junto a su sala y 
	 * enviarlo a la ruta que administra las salas del socket. 
	 * Ademas de guardar el mensaje en la base de datos
	 * @param roomId
	 * @param message
	 * @return el mensaje que se ha guardado en base de datos
	 */
	@MessageMapping("/chat/{roomId}")
	@SendTo("/topic/{roomId}")
	public ChatMessageDto chat(@DestinationVariable String roomId, MessageSendDto message) {
		MessageDto m = messageService.addMessage(message);
		return new ChatMessageDto(m.getIdMessage(), message.getUser(),message.getContent(), m.getStatus(), message.getSpoiler(), message.getAnonimous());
	}
	
}
