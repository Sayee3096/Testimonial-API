package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.pyt.veho.application", "com.pyt.veho.controller", "com.pyt.veho.Dao", "com.pyt.veho.Model",
		"com.pyt.veho.service", "com.pyt.veho.constants", "com.pyt.veho.exceptionHandler" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
