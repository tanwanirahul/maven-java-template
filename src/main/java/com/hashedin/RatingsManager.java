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

	public RatingsManager(UserManager userManager, MovieManager movieManager) {
		this.movieManager = movieManager;
		this.userManager = userManager;
	}

	public void storeRatings(InputStream ratingsData) throws IOException {
		List<String> lines = IOUtils.readLines(ratingsData);
		for (String line : lines) {
			Rating rating = parseRating(line);
			ratingMap.put(rating.getId(), rating);
		}

	}

	private Rating parseRating(String line) {
		Rating rating = new Rating();
		rating.setId(ratingMap.size() + 1);
		String[] tokens = line.split("\\s+");
		int userId = Integer.parseInt(tokens[0]);
		int movieId = Integer.parseInt(tokens[1]);
		int rate = Integer.parseInt(tokens[2]);
		long timeStamp = Long.parseLong(tokens[3]);
		rating.setRating(rate);
		rating.setTimeStamp(timeStamp);
		userManager.getUserMap().get(userId).getRatingIds().add(rating.getId());
		movieManager.getMovieMap().get(movieId).getRatingIds()
				.add(rating.getId());
		return rating;
	}

	public Map<Integer, Rating> getRatingMap() {
		return ratingMap;
	}

}
