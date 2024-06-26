package com.jacaranda.trd.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint{

	/**
	 * Si algún acceso no está autorizado este método lo captura y le devuelve
	 * lo que consideremos más oportuno. En este caso una respuesta de no autorizada
	 * Para que este método reciba las peticiones no aceptada hay que inyectar esta clase
	 * en la clase de seguridad y especificar que se usará para denegar las peticiones.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		//Añade cabecera
		response.addHeader("Content-Type", "application/json");
		//Establece el estado 401 Unauthorized
	    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

	    //Montamos el cuerpo de la respuesta
	    final Map<String, Object> body = new HashMap<>();
	    body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
	    body.put("error", "Unauthorized");
	    body.put("message", authException.getMessage());
	    body.put("path", request.getServletPath());

	    //Lo enviamos
	    final ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(response.getOutputStream(), body);
		
	}

}
