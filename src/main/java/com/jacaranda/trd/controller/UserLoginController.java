package com.jacaranda.trd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.trd.dto.JwtDto;
import com.jacaranda.trd.dto.LoginDto;
import com.jacaranda.trd.dto.UserDto;
import com.jacaranda.trd.dto.UserRegisterDto;
import com.jacaranda.trd.exception.BadRequest;
import com.jacaranda.trd.exception.CredentialNotValid;
import com.jacaranda.trd.model.UserLogin;
import com.jacaranda.trd.service.UserLoginService;
import com.jacaranda.trd.utility.TokenUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "UserLogin", description = "User login management APIs")
public class UserLoginController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserLoginService userLoginService;
	
	/**
     * singin se usa para loguearse. Se debe comprobar que el usuario y el password existen
     * y son correctas y devolver un token.
     * @param loginRequest: recibe un dto con el username y password que quier loguearse.
     * @return: debe devolver una respuesta con el token
     */
	@Operation(
		      summary = "Login\n",
		      description = "It allows you to log in to the website and returns the generated token")
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginRequest) {

		Authentication authentication;
		//Si el usuario y el password que le paso son los adecuados me 
		// devuele un autentication. Si no lo encuentra, lanza una exception
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	
		} catch (Exception e) {
			throw new CredentialNotValid(e.getMessage());
		}
		
		UserLogin user = (UserLogin)authentication.getPrincipal();
		String jwt = TokenUtils.generateToken(loginRequest.getUsername(), user.getRol());
		JwtDto jwtDto = new JwtDto(jwt);
		return ResponseEntity.ok(jwtDto);
	}
	
	
	/**
	 * Metodo para poder registrar a un nuevo usario en la base de datos. Se pedira los datos correspondiente 
	 * a un usuario y se comprobaran si estos tienen errore
	 * @param user
	 * @param errors
	 * @return El usuario recien recien registrado. Erro 400 si hubo algun error con los datos, si no se pudo gustrdar
	 * el suaurio
	 */
	@Operation(
		      summary = "Sing up\n",
		      description = "Allows you to register on the website")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody UserRegisterDto user, BindingResult errors){
		if(errors.hasErrors()) {
			throw new BadRequest(errors.getAllErrors().get(0).getDefaultMessage());
		}
		UserDto userAdd = userLoginService.register(user);
		if(userAdd!=null) {
			return ResponseEntity.ok(userAdd);
		}else {
			throw new BadRequest("Erros saving this user");
		}
	}
	
	/**
	 *  Metodo para poder comprobar si existe un usuario con el username introducido
	 * @param username
	 * @return Una lista con el usuario si hay alguno o la lista vacia
	 */
	@Operation(
		      summary = "Check if the username exists\n",
		      description = "Allows you to check if exist one user with this username")
	@Parameter(name = "username", description = "Username of the user we want to see if it exists", required=true)
	@GetMapping("/existUsername")
	public ResponseEntity<?> getUserName(@RequestParam("username") String username){
		List<UserDto> list = userLoginService.existUserName(username);
		return ResponseEntity.ok(list);
	}
	
}
