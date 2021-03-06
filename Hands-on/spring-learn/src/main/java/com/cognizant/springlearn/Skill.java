package com.cognizant.springlearn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Skill {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public Skill() {
		LOGGER.info("Inside Skill Constructor");
	}
	
	@NotNull
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 30, message = "Department name should be between 1 to 30 characters")
	private String name;
}
