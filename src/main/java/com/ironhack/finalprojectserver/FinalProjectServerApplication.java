package com.ironhack.finalprojectserver;

import com.ironhack.finalprojectserver.model.Role;
import com.ironhack.finalprojectserver.service.impl.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class FinalProjectServerApplication {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectServerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000");
			}
		};
	}

	@Bean
	CommandLineRunner run(RoleService roleService) {
		return args -> {
				roleService.saveRole(new Role("USER"));
				roleService.saveRole(new Role("OWNER"));
		};
	}
}
