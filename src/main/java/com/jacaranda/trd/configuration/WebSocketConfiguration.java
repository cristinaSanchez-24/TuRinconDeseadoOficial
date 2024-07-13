package com.jacaranda.trd.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{
	/*Clase donde vamos a configurar la logia de web socket*/

	/**
	 * Metido para poder configurar el broker, aqui vamos a mandar los mensajes con su room
	 * correspondiente
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}

	/**
	 * Metodo donde vamos a definir el end-point de nuestro chat socket, 
	 * para poder acceder a nuestro socket se usara la ruta por protocolo TCP
	 * '//localhost:8080/chat-socket' y debemos darle permiso a las rutas que van a 
	 * atacar a nuestro socket, en este caso nuestra ruta de fronted e indicamos que va a 
	 * utilizar SockJS libreria para socket en angular
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("chat-socket").setAllowedOrigins("https://tu-rincon-deseado-oficial.vercel.app/").withSockJS();
	}

	
	
}
