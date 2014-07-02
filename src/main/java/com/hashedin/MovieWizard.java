/**
 * 
 */
package com.hashedin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author hasher
 *
 */
public class MovieWizard {
	Map<Integer, Movie> movieMap;
	Map<Integer, User> userMap;
	Map<Integer, Rating> ratingMap;
	Map<Integer, List<Integer>> genreMap;

	public MovieWizard(Map<Integer, Movie> movieMap,
			Map<Integer, List<Integer>> genreMap, Map<Integer, User> userMap,
			Map<Integer, Rating> ratingMap) {
		this.movieMap = movieMap;
		this.userMap = userMap;
		this.ratingMap = ratingMap;
		this.genreMap = genreMap;
	}

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

	public Movie getTopMovieByGenre(int genreId) {
		List<Movie> filteredData = filterMoviesByGenre(genreId);
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

	public Movie getTopMovieByYear(int year) {
		List<Movie> movieList=new ArrayList<Movie>(movieMap.values());
		List<Movie> filteredData = filterMoviesByYear(movieList, year);
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

	public Movie getTopMovieByYearAndGenre(int year, int genre) {
		List<Movie> filteredData = filterMoviesByGenre(genre);
		filteredData = filterMoviesByYear(filteredData, year);

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

	// public List<Movie> filterMovieByGenre(List<Movie>,)

	private List<Movie> filterMoviesByGenre(int genreName) {

		List<Integer> movieIds = genreMap.get(genreName);
		List<Movie> filteredList = new ArrayList<Movie>();

		for (Integer movieId : movieIds) {
			filteredList.add(movieMap.get(movieId));
		}
		return filteredList;
	}

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

}
