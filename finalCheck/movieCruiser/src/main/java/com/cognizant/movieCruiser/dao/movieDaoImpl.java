package com.cognizant.movieCruiser.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.movieCruiser.model.favorite;
import com.cognizant.movieCruiser.model.movie;

@Repository
public class movieDaoImpl implements movieDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(movieDaoImpl.class);

	private static ApplicationContext context = new ClassPathXmlApplicationContext("movie.xml");
	private static ArrayList<movie> MOVIE_LIST = context.getBean("movieList", java.util.ArrayList.class);

	private static HashMap<String, favorite> favoriteList = new HashMap<String, favorite>();

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

		LOGGER.debug("STARTS");
		SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = sdfo.parse("15/06/2020");

		ArrayList<movie> finalList = (ArrayList<movie>) MOVIE_LIST.stream()
				.filter(movie -> (movie.isActive() && movie.getDateOfLaunch().before(currentDate)))
				.collect(Collectors.toList());

		LOGGER.debug("END");
		return finalList;
	}

	@Override
	public ArrayList<movie> getFavoriteMoviesCustomer(String userId) {
		LOGGER.debug("STARTS");
		if (favoriteList.containsKey(userId)) {
			favorite fav = favoriteList.get(userId);
			ArrayList<Integer> list = fav.getFavoriteMovies();
			ArrayList<movie> movielist = new ArrayList<movie>();

			for (int i = 0; i < list.size(); i++) {

				for (int j = 0; j < MOVIE_LIST.size(); j++) {
					if (MOVIE_LIST.get(j).getId() == list.get(i)) {
						movielist.add(MOVIE_LIST.get(j));
					}
				}

			}

			return movielist;
		}
		return null;
	}

	@Override
	public void addFavoriteMovieCustomer(String userId, int movieId) {
		LOGGER.debug("STARTS");
		if (favoriteList.isEmpty()) {
			favorite fav = new favorite();
			ArrayList<Integer> list = new ArrayList<Integer>();
			LOGGER.debug("BEFORE: " + list.toString());
			list.add(movieId);
			fav.setFavoriteMovies(list);
			favoriteList.put(userId, fav);
			LOGGER.debug("AFTER: " + list.toString());
		} else if (favoriteList.containsKey(userId)) {
			favorite fav = favoriteList.get(userId);
			ArrayList<Integer> list = fav.getFavoriteMovies();
			LOGGER.debug("BEFORE: " + list.toString());
			if (!list.contains(movieId))
				list.add(movieId);
			fav.setFavoriteMovies(list);
			favoriteList.put(userId, fav);
			LOGGER.debug("AFTER: " + list.toString());
		} else {
			favorite fav = new favorite();
			ArrayList<Integer> list = new ArrayList<Integer>();
			LOGGER.debug("BEFORE: " + list.toString());
			list.add(movieId);
			fav.setFavoriteMovies(list);
			favoriteList.put(userId, fav);
			LOGGER.debug("AFTER: " + list.toString());
		}

		LOGGER.debug("END");
	}

	@Override
	public void removeFavoriteMovieCustomer(String userId, int movieId) {
		LOGGER.debug("STARTS");
		if (favoriteList.containsKey(userId)) {
			favorite fav = favoriteList.get(userId);
			ArrayList<Integer> list = fav.getFavoriteMovies();
			LOGGER.debug("BEFORE: " + list.toString());
			if (list.contains(movieId)) {
				int index = list.indexOf(movieId);
				list.remove(index);
			}
			fav.setFavoriteMovies(list);
			favoriteList.put(userId, fav);
			LOGGER.debug("AFTER: " + list.toString());
		}
		LOGGER.debug("END");
	}
}
