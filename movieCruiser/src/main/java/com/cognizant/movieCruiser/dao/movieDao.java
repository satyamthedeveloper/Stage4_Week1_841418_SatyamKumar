package com.cognizant.movieCruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.cognizant.movieCruiser.model.movie;

public interface movieDao {

	ArrayList<movie> getAllMoviesAdmin();

	void editMovieAdmin(movie updateMovie, int movieId);

	ArrayList<movie> getAllMoviesCustomer();

	ArrayList<movie> getActiveMoviesCustomer() throws ParseException;

}
