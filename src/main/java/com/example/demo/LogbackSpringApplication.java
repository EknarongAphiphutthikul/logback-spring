package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackSpringApplication {

	public static void main(String[] args) {
		System.setProperty("SERVICE_SYSTEM","serviceSystemTest");
		SpringApplication.run(LogbackSpringApplication.class, args);
	}

}
