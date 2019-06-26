package com.vic.serialization;

public class Father /*implements Serializable*/ {
	

	private String username;
	
	private String gender;
	
	private int age;
	
	public Father() {
		this.username = "king";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Father [username=" + username + ", gender=" + gender + ", age="
				+ age + "]";
	}

}
