package com.cognizant.movieCruiser.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movieCruiser.model.movie;
import com.cognizant.movieCruiser.service.movieService;

@RestController
@RequestMapping("/movies")
public class movieControllerCustomer {

	@Autowired
	private movieService ms;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(movieControllerCustomer.class);

	@GetMapping
	public ArrayList<movie> getAllMoviesCustomer() {
		LOGGER.info("START");
		return ms.getAllMoviesCustomer();
	}
	
	@GetMapping("/active")
	public ArrayList<movie> getActiveMoviesCustomer() throws ParseException {
		LOGGER.info("START");
		return ms.getActiveMoviesCustomer();
	}
	
	

}
