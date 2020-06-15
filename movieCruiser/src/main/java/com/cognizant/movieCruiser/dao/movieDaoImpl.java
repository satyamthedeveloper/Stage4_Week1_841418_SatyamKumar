package com.cognizant.movieCruiser.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.movieCruiser.model.movie;

@Repository
public class movieDaoImpl implements movieDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(movieDaoImpl.class);

	private static ApplicationContext context = new ClassPathXmlApplicationContext("movie.xml");
	private static ArrayList<movie> MOVIE_LIST = context.getBean("movieList", java.util.ArrayList.class);

	@Override
	public ArrayList<movie> getAllMoviesAdmin() {
		LOGGER.debug("STARTS");
		return MOVIE_LIST;
	}

	@Override
	public void editMovieAdmin(movie updateMovie, int movieId) {
		// TODO Auto-generated method stub
		LOGGER.debug(updateMovie.toString());
	}

	@Override
	public ArrayList<movie> getAllMoviesCustomer() {
		LOGGER.debug("STARTS");
		return MOVIE_LIST;
	}

	@Override
	public ArrayList<movie> getActiveMoviesCustomer() throws ParseException {

		SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = sdfo.parse("15/06/2020");

		ArrayList<movie> finalList = (ArrayList<movie>) MOVIE_LIST.stream()
				.filter(movie -> (movie.isActive() && movie.getDateOfLaunch().before(currentDate)))
				.collect(Collectors.toList());

		return finalList;
	}

}
