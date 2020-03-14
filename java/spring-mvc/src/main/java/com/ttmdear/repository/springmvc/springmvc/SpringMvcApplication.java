package com.ttmdear.repository.springmvc.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringMvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}
}
