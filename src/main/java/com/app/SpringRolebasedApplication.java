package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRolebasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRolebasedApplication.class, args);
		System.out.println("Hi");
	}

}
