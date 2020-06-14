package com.cognizant.springlearn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Department {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Department() {
		LOGGER.info("Inside Department Constructor");
	}

	@NotNull
	private int id;

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@NotBlank
	@Size(min = 1, max = 30, message = "Department name should be between 1 to 30 characters")
	private String name;

}
