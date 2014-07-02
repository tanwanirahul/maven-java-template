package com.hashedin;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		MovieManager movieManager = new MovieManager("movie.data");
		UserManager userManager = new UserManager("user.data");
		RatingsManager ratingsManager = new RatingsManager(userManager,
				movieManager, "ratings.data");

		MovieWizard movieWizard = new MovieWizard(movieManager.getMovieMap(),
				userManager.getUserMap(), ratingsManager.getRatingMap());

		System.out.println(movieWizard.getMostActiveUser());

		System.out.println(movieWizard.getMostWatchedMovie());
		
		System.out.println(movieManager.getGenreMap().get(Constants.action).toString());
		// System.out.println(movieManager.getMovieMap().get(1));

	}

}
