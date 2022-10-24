package com.sg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class StudentRegistrationMVC {	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentRegistrationMVC.class, args);
	}

}