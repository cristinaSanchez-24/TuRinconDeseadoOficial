package com.jacaranda.trd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.jacaranda.trd.dto.UserDto;
import com.jacaranda.trd.dto.UserRegisterDto;
import com.jacaranda.trd.exception.BadRequest;
import com.jacaranda.trd.exception.NotFound;
import com.jacaranda.trd.model.UserLogin;
import com.jacaranda.trd.repository.UserLoginRepository;
import com.jacaranda.trd.utility.ConvertsDto;



public class UserLoginService implements UserDetailsService{
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserLoginRepository userLoginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin result =  userLoginRepository.findById(username).orElse(null);
		if (result != null)
			return result;
		else
			throw new NotFound("Usuario no encontrado username: " + username);
		
	}
	
	/**
	 * Metodo para registrar un nuevo usuario a la base de datos, debe comprobar que el
	 * username y emial no existe y debera encriptar la contraseña y enviar un correo informativo
	 * @param user
	 * @return El usuario recien registrao. Error 400: si hubo un error al guardarlo, si el 
	 * email ya existe, si el username ya existe, si hay un error al enviar el correo
	 * @throws BadRequest 
	 */
	public UserDto register(UserRegisterDto user) {
		UserLogin userFind = userLoginRepository.findById(user.getUsername()).orElse(null);
		if(userFind==null) {
			List<UserLogin> userEmail = userLoginRepository.findByEmail(user.getEmail());
			if(userEmail.size()==0) {
				UserLogin userLoginAdd = new UserLogin(user.getUsername(), "user", user.getPassword(), user.getEmail());
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encoderPassword = passwordEncoder.encode(user.getPassword());
				userLoginAdd.setPassword(encoderPassword);

				if(user.getImage()!=null && !user.getImage().isEmpty()) {
					userLoginAdd.setImage(user.getImage());
				}else {
					userLoginAdd.setImage(null);
				}
				UserLogin userAux = userLoginRepository.save(userLoginAdd);
				if(userAux!=null) {
					return ConvertsDto.userToUserDto(userAux);
				}else {
					throw new BadRequest("Error to saving a user");
				}
			}else {
				throw new BadRequest("This email already exist");
			}
		}else {
			throw new BadRequest("This username already exist");
		}
		
	}
	
	/**
	 * Metodo para poder comprobar si hay un uaurio con el username introducido 
	 * @param name
	 * @return el usuario econtrado o null si no lo encuentra
	 */
	public List<UserDto> existUserName(String name) {
		UserLogin user = userLoginRepository.findById(name).orElse(null);
		UserDto userDto = null;
		List<UserDto> lista = new ArrayList<UserDto>();
		if(user!=null) {
			userDto = ConvertsDto.userToUserDto(user);	
			lista.add(userDto);
		}
		return lista;
	}
	
	/**
	 * Metodo para poder comprobar si hay un uaurio con el username introducido 
	 * @param name
	 * @return el usuario econtrado o null si no lo encuentra
	 */
	public List<UserDto> existEmail(String email) {
		List<UserLogin> userLoginList = userLoginRepository.findByEmail(email);
		List<UserDto> lista = new ArrayList<UserDto>();
		if(userLoginList.size()>0) {
			lista = ConvertsDto.getListUserDto(userLoginList);
		}
		return lista;
	}
		
	
}
