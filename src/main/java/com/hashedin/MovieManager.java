package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class MovieManager {

	Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();

	public void storeMovie(InputStream movieData) throws IOException {

		List<String> lines = IOUtils.readLines(movieData);
		for (String line : lines) {
			Movie movie = parseMovie(line);
			
			movieMap.put(movie.getId(), movie);
		}
	}

	private Movie parseMovie(String line) {
		String[] tokens = line.split("\\|");
		Movie movie = new Movie();
		movie.setId(Integer.parseInt(tokens[0]));
		movie.setTitle(tokens[1]);
		movie.setReleaseDate(tokens[2]);
		movie.setVideoReleaseDate(tokens[3]);
		movie.setImdbUrl(tokens[4]);
		Genre genre = setGenre(tokens);
		movie.setGenre(genre);
		return movie;
	}

	private Genre setGenre(String[] tokens) {
		Genre genre = new Genre();
		genre.setUnknown(getBooleanFromToken(tokens[5]));
		genre.setAction(getBooleanFromToken(tokens[6]));
		genre.setAdventure(getBooleanFromToken(tokens[7]));
		genre.setAnimation(getBooleanFromToken(tokens[8]));
		genre.setChildren(getBooleanFromToken(tokens[9]));
		genre.setComedy(getBooleanFromToken(tokens[10]));
		genre.setCrime(getBooleanFromToken(tokens[11]));
		genre.setDocumentary(getBooleanFromToken(tokens[12]));
		genre.setDrama(getBooleanFromToken(tokens[13]));
		genre.setFantasy(getBooleanFromToken(tokens[14]));
		genre.setFilmNoir(getBooleanFromToken(tokens[15]));
		genre.setHorror(getBooleanFromToken(tokens[16]));
		genre.setMusical(getBooleanFromToken(tokens[17]));
		genre.setMystery(getBooleanFromToken(tokens[18]));
		genre.setRomance(getBooleanFromToken(tokens[19]));
		genre.setSciFi(getBooleanFromToken(tokens[20]));
		genre.setThriller(getBooleanFromToken(tokens[21]));
		genre.setWar(getBooleanFromToken(tokens[22]));
		genre.setWestern(getBooleanFromToken(tokens[23]));

		return genre;
	}

	private boolean getBooleanFromToken(String nextToken) {
		if (Integer.parseInt(nextToken) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Map<Integer, Movie> getMovieMap() {
		return movieMap;
	}

}
