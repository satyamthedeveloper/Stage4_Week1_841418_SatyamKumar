package com.cognizant.truYum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TruYumApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TruYumApplication.class, args);
		LOGGER.info("TruYum Application Starts");
		
	}

}
