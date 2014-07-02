package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class MovieManager {

	Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
	Map<Integer, List<Integer>> genreMap = new HashMap<Integer, List<Integer>>();
	InputStream movieData;

	public MovieManager(String fileName) throws IOException {
		this.movieData = getClass().getClassLoader().getResourceAsStream(
				fileName);

		this.store(movieData);
	}

	public void store(InputStream movieData) throws IOException {

		List<String> lines = IOUtils.readLines(movieData);
		for (String line : lines) {
			Movie movie = parse(line);
			movieMap.put(movie.getId(), movie);
		}
	}

	private Movie parse(String line) {
		String[] tokens = line.split("\\|");
		Movie movie = new Movie();
		movie.setId(Integer.parseInt(tokens[0]));
		movie.setTitle(tokens[1]);
		movie.setReleaseDate(tokens[2]);
		movie.setVideoReleaseDate(tokens[3]);
		movie.setImdbUrl(tokens[4]);
		setGenre(tokens, movie.getId());
		// movie.setGenre(genre);
		return movie;
	}

	private void setGenre(String[] tokens, int movieId) {
		// Genre genre = new Genre();
		for (int tokenId = 5, genreId = 0; tokenId < 24 && genreId < 19; tokenId++, genreId++) {
			getBooleanFromToken(tokens[tokenId], genreId, movieId);
		}
		//
		// genre.setAction(getBooleanFromToken(tokens[6],Constants.action,movieId));
		// genre.setAdventure(getBooleanFromToken(tokens[7],Constants.adventure,movieId));
		// genre.setAnimation(getBooleanFromToken(tokens[8],Constants.animation,movieId));
		// genre.setChildren(getBooleanFromToken(tokens[9]));
		// genre.setComedy(getBooleanFromToken(tokens[10]));
		// genre.setCrime(getBooleanFromToken(tokens[11]));
		// genre.setDocumentary(getBooleanFromToken(tokens[12]));
		// genre.setDrama(getBooleanFromToken(tokens[13]));
		// genre.setFantasy(getBooleanFromToken(tokens[14]));
		// genre.setFilmNoir(getBooleanFromToken(tokens[15]));
		// genre.setHorror(getBooleanFromToken(tokens[16]));
		// genre.setMusical(getBooleanFromToken(tokens[17]));
		// genre.setMystery(getBooleanFromToken(tokens[18]));
		// genre.setRomance(getBooleanFromToken(tokens[19]));
		// genre.setSciFi(getBooleanFromToken(tokens[20]));
		// genre.setThriller(getBooleanFromToken(tokens[21]));
		// genre.setWar(getBooleanFromToken(tokens[22]));
		// genre.setWestern(getBooleanFromToken(tokens[23]));

	}

	private void getBooleanFromToken(String nextToken, int genreId, int movieId) {
		if (Integer.parseInt(nextToken) == 1) {
			if (genreMap.get(genreId) == null) {
				List<Integer> movieIds = new ArrayList<Integer>();
				movieIds.add(movieId);
				genreMap.put(genreId, movieIds);
			} else {
				genreMap.get(genreId).add(movieId);
			}
		}
	}

	public Map<Integer, Movie> getMovieMap() {
		return movieMap;
	}

	public Map<Integer, List<Integer>> getGenreMap() {
		return genreMap;
	}

}
