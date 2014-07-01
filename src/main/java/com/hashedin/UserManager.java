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

	public void storeUsers(InputStream userData) throws IOException {
		List<String> lines = IOUtils.readLines(userData);
		for (String line : lines) {
			User user = parseUser(line);
			userMap.put(user.getId(), user);

		}
	}

	private User parseUser(String line) {
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
