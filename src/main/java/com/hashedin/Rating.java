package com.hashedin;

public class Rating {
	private User user;
	private Movies movies;
	private int rating;
	private long timeStamp;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Rating [user=" + user + ", movies=" + movies + ", rating="
				+ rating + ", timeStamp=" + timeStamp + "]";
	}

}
