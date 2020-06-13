package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	
	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters")
	private String code;
	private String name;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public Country() {
		// TODO Auto-generated constructor stub
		LOGGER.info("Inside Country Constructor");
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

	public String getCode() {
		LOGGER.debug("Inside Country getCode()");
		return code;
		
	}

	public void setCode(String code) {
		LOGGER.debug("Inside Country setCode()");
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("Inside Country getName()");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside Country setName()");
		this.name = name;
	}
}
