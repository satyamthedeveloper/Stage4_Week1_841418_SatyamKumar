package com.cognizant.movieCruiser.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{userId}/favorite")
	public ArrayList<movie> getFavoriteMoviesCustomer(@PathVariable("userId") String userId){
		LOGGER.info("START");
		return ms.getFavoriteMoviesCustomer(userId);
	}
	
	@PutMapping("/{userId}/{movieId}")
	public void addFavoriteMovieCustomer(@PathVariable("userId") String userId, @PathVariable("movieId") int movieId) {
		LOGGER.info("START");
		ms.addFavoriteMovieCustomer(userId, movieId);
		LOGGER.info("END");
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	public void removeFavoriteMovieCustomer(@PathVariable("userId") String userId, @PathVariable("movieId") int movieId) {
		LOGGER.info("START");
		ms.removeFavoriteMovieCustomer(userId, movieId);
		LOGGER.info("END");
	}
}
