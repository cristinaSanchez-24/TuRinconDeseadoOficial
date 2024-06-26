package com.jacaranda.trd.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.trd.dto.MessageDto;
import com.jacaranda.trd.dto.MessageEditDto;
import com.jacaranda.trd.model.Message;
import com.jacaranda.trd.service.MessageServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class MessageController {
/*Controlador para los mensajes que estan en la base de datos*/
	@Autowired
	private MessageServices messageService;
	
	/**
	 * Metodo para traer los mensajes de la base de datos y ordenarlos por la fecha y la hora
	 * @return json con los mensajes ordenados
	 */
	@Operation(
		      summary = "Get a message list order by date\n",
		      description = "Allows users to view a list of messages that are stored in the database")
	@GetMapping("/getMessages")
	public ResponseEntity<?> getMessages(){
		List<MessageDto> messages = messageService.getMessages();
        Collections.sort(messages, (m1, m2) -> m1.getDate().compareTo(m2.getDate()));
		return ResponseEntity.ok(messages);
	}
	
	/**
	 * Metodo para que un administrador pueda borrar un mensaje que no le parezca apropiado
	 * @param idMessage
	 * @return json con el mensaje borrado
	 */
	@Operation(
		      summary = "Delete a message\n",
		      description = "Allows admin to delete a messages")
	@DeleteMapping("/deleteMessage/{id}")
	public ResponseEntity<?> deleteMessage(@PathVariable Integer id){
		MessageDto message = messageService.deleteMessage(id);
		return ResponseEntity.ok(message);
	}
	
	/**
	 * Metodo para que un usuario edite un mensaje en caso de que sea necesario
	 * @param idMessage
	 * @param message
	 * @return json con el mensaje eidtado
	 */
	@Operation(
		      summary = "Edit a message\n",
		      description = "Allows user to edit a messages if they want")
	@PutMapping("/editMessage/{id}")
	public ResponseEntity<?> editMessage(@PathVariable Integer id, @RequestBody MessageEditDto message){
		MessageDto messageEdit = messageService.editMessage(id, message);
		return ResponseEntity.ok(messageEdit);
	}
	
	
}
