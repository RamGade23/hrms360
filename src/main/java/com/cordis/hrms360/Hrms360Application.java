package com.cordis.hrms360;

import com.cordis.hrms360.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Hrms360Application {
	public static void main(String[] args) {
		System.out.println("this is main class");
		SpringApplication.run(Hrms360Application.class, args);
	}
}
