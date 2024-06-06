package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;



@SpringBootApplication

@OpenAPIDefinition(
	       info = @Info(
	             title = "Employee Detail Management",
	             version = "1.0",
	             description = "API for managing employee details"
	       ), 
	       servers = 
	             @Server(url = "http://localhost:8080",
	                   description = "Employee Open API url") 
	       )

public class EmployeeApplication  {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	
	



}
