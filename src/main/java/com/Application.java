package com;

/*
 * FileName: Testimonial API Main Class
 * Version: V1
 *
 * Functionality: This class is used for starting the SpringBoot Application which includes all the 
 * packages inside @ComponentScan.
 * 
 * Execution: Run as Java Application
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pyt.veho.controller.TestimonialsController;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.pyt.veho.application", "com.pyt.veho.controller", "com.pyt.veho.Dao", "com.pyt.veho.Model", "com.pyt.veho.service",
	"com.pyt.veho.constants","com.pyt.veho.exceptionHandler"})
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(TestimonialsController.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("Application Started successfully");
	}

}
