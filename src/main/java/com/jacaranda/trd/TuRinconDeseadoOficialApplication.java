package com.jacaranda.trd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TuRinconDeseadoOficialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuRinconDeseadoOficialApplication.class, args);
	}
	
	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {
			
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
				.allowedOrigins("http://localhost:4200/", "http://render.com", "https://tu-rincon-deseado-oficial.vercel.app/")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
				.allowCredentials(true);
		}
	}

}
