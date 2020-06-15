package com.cognizant.movieCruiser.service;

import java.text.ParseException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movieCruiser.MovieCruiserApplication;
import com.cognizant.movieCruiser.dao.movieDao;
import com.cognizant.movieCruiser.model.movie;

@Service
public class movieService {

	@Autowired
	private movieDao md;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(movieService.class);
	
	public ArrayList<movie> getAllMoviesAdmin() {
		// TODO Auto-generated method stub
		LOGGER.debug("movieService Starts");
		return md.getAllMoviesAdmin();
	}

	public void editMovieAdmin(movie updateMovie, int movieId) {
		// TODO Auto-generated method stub
		LOGGER.debug("START");
		md.editMovieAdmin(updateMovie, movieId);
		
	}

	public ArrayList<movie> getAllMoviesCustomer() {
		// TODO Auto-generated method stub
		LOGGER.debug("START");
		return md.getAllMoviesCustomer();
	}

	public ArrayList<movie> getActiveMoviesCustomer() throws ParseException {
		// TODO Auto-generated method stub
		LOGGER.debug("START");
		return md.getActiveMoviesCustomer();
	}

}
