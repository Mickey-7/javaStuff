package com.example.springbootmvcandjdbccrudexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringBootMvcAndJdbcCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcAndJdbcCrudExampleApplication.class, args);
	}

}
