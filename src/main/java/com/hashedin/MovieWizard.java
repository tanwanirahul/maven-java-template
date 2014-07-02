/**
 * 
 */
package com.hashedin;

import java.util.Map;

/**
 * @author hasher
 *
 */
public class MovieWizard {

	public User getMostActiveUser(Map<Integer,User> userMap) {
		int maxLength = 0;
		int userId = 0;
		for (User user : userMap.values()) {
			if (user.getRatingIds().size() > maxLength) {
				maxLength = user.getRatingIds().size();
				userId = user.getId();
			}
		}
		return userMap.get(userId);
	}
	
}
