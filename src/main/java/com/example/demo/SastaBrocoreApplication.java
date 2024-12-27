package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = { 
		@Server(url = "http://localhost:8080", description = "Generated Server URL")

	 })
@SpringBootApplication
public class SastaBrocoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SastaBrocoreApplication.class, args);
	}

}
