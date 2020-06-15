package com.cognizant.movieCruiser.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movieCruiser.MovieCruiserApplication;
import com.cognizant.movieCruiser.model.movie;
import com.cognizant.movieCruiser.service.movieService;

@RestController
@RequestMapping("/admin/movies")
public class movieController {

	@Autowired
	private movieService ms;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(movieController.class);
	
	@GetMapping
	public ArrayList<movie> getAllMoviesAdmin() {
		LOGGER.info("movieController STARTS");
		return ms.getAllMoviesAdmin();
	}
	
	@PutMapping("/{movieId}")
	public void editMovieAdmin(@RequestBody movie updateMovie, @PathVariable("movieId") int movieId) {
		LOGGER.info("START");
		ms.editMovieAdmin(updateMovie, movieId);
	}
}
