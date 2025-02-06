package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("Spring Boot JPA Repository Started..!");
		
		EmployeeService service =context.getBean(EmployeeService.class);
		
		service.check();
	}

}
