package com.hashedin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;

public class UserManager {
	Map<Integer, User> userMap = new HashMap<Integer, User>();
	InputStream userData;

	public UserManager(String fileName) throws IOException {
		this.userData = getClass().getClassLoader().getResourceAsStream(
				fileName);

		this.store(userData);
	}

	public void store(InputStream userData) throws IOException {
		List<String> lines = IOUtils.readLines(userData);
		for (String line : lines) {
			User user = parse(line);
			userMap.put(user.getId(), user);

		}
	}

	private User parse(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line, "|");
		User user = new User();
		user.setId(Integer.parseInt(tokenizer.nextToken()));
		user.setAge(Integer.parseInt(tokenizer.nextToken()));
		user.setGender(tokenizer.nextToken());
		user.setOccupation(tokenizer.nextToken());
		user.setZipCode(tokenizer.nextToken());
		return user;
	}

	public Map<Integer, User> getUserMap() {
		return userMap;
	}

}
