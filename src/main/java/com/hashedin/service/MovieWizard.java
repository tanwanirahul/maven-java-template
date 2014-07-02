/**
 * 
 */
package com.hashedin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hashedin.model.Movie;
import com.hashedin.model.Rating;
import com.hashedin.model.User;

/**
 * @author hasher
 *
 */
public class MovieWizard {
	Map<Integer, Movie> movieMap;
	Map<Integer, User> userMap;
	Map<Integer, Rating> ratingMap;
	Map<Integer, List<Integer>> genreMap;

	/**
	 * @param movieMap
	 * @param genreMap
	 * @param userMap
	 * @param ratingMap
	 */
	public MovieWizard(Map<Integer, Movie> movieMap,
			Map<Integer, List<Integer>> genreMap, Map<Integer, User> userMap,
			Map<Integer, Rating> ratingMap) {
		this.movieMap = movieMap;
		this.userMap = userMap;
		this.ratingMap = ratingMap;
		this.genreMap = genreMap;
	}

	/**
	 * Gets Most active User(who Rates the most)
	 * 
	 * @return
	 */
	public User getMostActiveUser() {
		int maxLength = 0;
		int userId = 0;
		for (User user : userMap.values()) {
			if (user.getRatingIds().size() > maxLength) {
				maxLength = user.getRatingIds().size();
				userId = user.getId();
			}
		}
		return userMap.get(userId);
	}

	/**
	 * Gets the most watched movie
	 * 
	 * @return
	 */
	public Movie getMostWatchedMovie() {
		int maxLength = 0;
		int id = 0;
		for (Movie movie : movieMap.values()) {
			if (movie.getRatingIds().size() > maxLength) {
				maxLength = movie.getRatingIds().size();
				id = movie.getId();
			}
		}
		return movieMap.get(id);
	}

	/**
	 * gets top movie filtered by genre
	 * 
	 * @param genreId
	 * @return
	 */
	public Movie getTopMovieByGenre(int genreId) {
		List<Movie> filteredData = filterMoviesByGenre(genreId);
		return getTopMovie(filteredData);
	}

	/**
	 * gets top movie filtered by year
	 * 
	 * @param year
	 * @return
	 */
	public Movie getTopMovieByYear(int year) {
		List<Movie> movieList = new ArrayList<Movie>(movieMap.values());
		List<Movie> filteredData = filterMoviesByYear(movieList, year);
		return getTopMovie(filteredData);

	}

	/**
	 * gets top movie filtered by genre and year
	 * 
	 * @param year
	 * @param genre
	 * @return
	 */
	public Movie getTopMovieByYearAndGenre(int year, int genre) {
		List<Movie> filteredData = filterMoviesByGenre(genre);
		filteredData = filterMoviesByYear(filteredData, year);

		return getTopMovie(filteredData);
	}

	/**
	 * @param genreName
	 * @return
	 */
	private List<Movie> filterMoviesByGenre(int genreName) {

		List<Integer> movieIds = genreMap.get(genreName);
		List<Movie> filteredList = new ArrayList<Movie>();

		for (Integer movieId : movieIds) {
			filteredList.add(movieMap.get(movieId));
		}
		return filteredList;
	}

	/**
	 * @param initialData
	 * @param year
	 * @return
	 */
	private List<Movie> filterMoviesByYear(List<Movie> initialData, int year) {
		List<Movie> filteredList = new ArrayList<Movie>();

		for (Movie movie : initialData) {
			String releaseDate = movie.getReleaseDate();
			if (releaseDate.length() > 0) {
				int yearFromText = Integer.parseInt(releaseDate
						.substring(releaseDate.length() - 4));
				if (yearFromText == year) {
					filteredList.add(movie);
				}
			}
		}
		return filteredList;
	}

	/**
	 * @param filteredData
	 * @return
	 */
	private Movie getTopMovie(List<Movie> filteredData) {
		double max = 0;
		int id = 0;
		for (Movie movie : filteredData) {
			int movieId = movie.getId();
			if (movieMap.get(movieId).getAvgRating() > max) {
				max = movieMap.get(movieId).getAvgRating();
				id = movieMap.get(movieId).getId();
			}
		}
		return movieMap.get(id);
	}

}
