package com.example.stockmarketapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.stockmarketapp.dao.UserDao;
import com.example.stockmarketapp.model.*;
import com.example.stockmarketapp.service.UserServiceImpl;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		User demoUser = new User("testAdmin", "password", Role.ADMIN, "test@admin.com", "", false);
	}

}
