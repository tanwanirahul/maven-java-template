package com.hashedin.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private int age;
	private String gender;
	private String occupation;
	private String zipCode;
	private List<Integer> ratingIds = new ArrayList<Integer>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Integer> getRatingIds() {
		return ratingIds;
	}

	public void setRatingIds(List<Integer> ratingIds) {
		this.ratingIds = ratingIds;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", gender=" + gender
				+ ", occupation=" + occupation + ", zipCode=" + zipCode
				+ ", ratingIds=" + ratingIds + "]" + ratingIds.size();
	}

}
