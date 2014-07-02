package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class RatingsManager {
	Map<Integer, Rating> ratingMap = new HashMap<Integer, Rating>();
	MovieManager movieManager;
	UserManager userManager;
	InputStream ratingsData;

	public RatingsManager(UserManager userManager, MovieManager movieManager,
			String fileName) throws IOException {
		this.movieManager = movieManager;
		this.userManager = userManager;
		this.ratingsData = getClass().getClassLoader().getResourceAsStream(
				fileName);

		this.store(ratingsData);
	}

	public void store(InputStream ratingsData) throws IOException {
		List<String> lines = IOUtils.readLines(ratingsData);
		for (String line : lines) {
			Rating rating = parse(line);
			// System.out.println(rating.toString() + "\n");
			ratingMap.put(rating.getId(), rating);
		}

	}

	private Rating parse(String line) {

		String[] tokens = line.split("\\s+");

		int userId = Integer.parseInt(tokens[0]);
		int movieId = Integer.parseInt(tokens[1]);
		int rate = Integer.parseInt(tokens[2]);
		long timeStamp = Long.parseLong(tokens[3]);

		Rating rating = new Rating();
		rating.setId(ratingMap.size() + 1);
		rating.setRating(rate);
		rating.setTimeStamp(timeStamp);

		userManager.getUserMap().get(userId).getRatingIds().add(rating.getId());
		movieManager.getMovieMap().get(movieId)
				.setAvgRating(getAverageRating(movieId, rate));
		movieManager.getMovieMap().get(movieId).getRatingIds()
				.add(rating.getId());

		return rating;
	}

	
	/**
	 * Get the average rating of the movie calculated on the previous rates
	 * 
	 * @param movieId
	 * @param rate
	 * @return
	 */
	private double getAverageRating(int movieId, int rate) {
		Map<Integer, Movie> movieMap = movieManager.getMovieMap();

		double avgRate = movieMap.get(movieId).getAvgRating();

		int noOfRating = movieMap.get(movieId).getRatingIds().size();

		return ((avgRate * noOfRating) + rate) / (noOfRating + 1);

	}

	public Map<Integer, Rating> getRatingMap() {
		return ratingMap;
	}

}
