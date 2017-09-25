package com.example.dbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DbappApplication {

	@RequestMapping("/")
	String hello(){
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DbappApplication.class, args);
	}
}
