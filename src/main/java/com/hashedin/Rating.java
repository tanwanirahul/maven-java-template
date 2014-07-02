package com.hashedin;

public class Rating {
	
	private int id;
	private int rating;
	private long timeStamp;

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
		return "Rating [rating=" + rating + ", timeStamp=" + timeStamp + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
