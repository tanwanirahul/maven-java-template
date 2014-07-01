package com.hashedin;

import java.util.List;

public class Movie {
	private int id;
	private String title;
	private String releaseDate;
	private String videoReleaseDate;
	private String imdbUrl;
	private Genre genre;
	private List<Integer> ratingIds;
	
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", releaseDate="
				+ releaseDate + ", videoReleaseDate=" + videoReleaseDate
				+ ", imdbUrl=" + imdbUrl + ", genre=" + genre + "]";
	}

	public List<Integer> getRatingIds() {
		return ratingIds;
	}

	public void setRatingIds(List<Integer> ratingIds) {
		this.ratingIds = ratingIds;
	}

}
