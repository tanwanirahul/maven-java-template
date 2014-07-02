package com.hashedin;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private int id;
	private String title;
	private String releaseDate;
	private String videoReleaseDate;
	private String imdbUrl;
	private List<Integer> ratingIds = new ArrayList<Integer>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getVideoReleaseDate() {
		return videoReleaseDate;
	}

	public void setVideoReleaseDate(String videoReleaseDate) {
		this.videoReleaseDate = videoReleaseDate;
	}

	public String getImdbUrl() {
		return imdbUrl;
	}

	public void setImdbUrl(String imdbUrl) {
		this.imdbUrl = imdbUrl;
	}

	public List<Integer> getRatingIds() {
		return ratingIds;
	}

	public void setRatingIds(List<Integer> ratingIds) {
		this.ratingIds = ratingIds;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releaseDate="
				+ releaseDate + ", videoReleaseDate=" + videoReleaseDate
				+ ", imdbUrl=" + imdbUrl + ", ratingIds=" + ratingIds + "]"
				+ ratingIds.size();
	}

}
