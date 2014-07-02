/**
 * 
 */
package com.hashedin;

import java.util.Map;

/**
 * @author hasher
 *
 */
public class MovieWizard {
	Map<Integer, Movie> movieMap;
	Map<Integer, User> userMap;
	Map<Integer, Rating> ratingMap;

	public MovieWizard(Map<Integer, Movie> movieMap,
			Map<Integer, User> userMap, Map<Integer, Rating> ratingMap) {
		this.movieMap = movieMap;
		this.userMap = userMap;
		this.ratingMap = ratingMap;
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

	public String getMostWarchedGenre() {
		
		return null;
	}
//	public List<Movie> filterMovieByGenre(List<Movie>,)

}
