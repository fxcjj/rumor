package com.vic.serialization;
import java.io.Serializable;

public class Cat implements Serializable {
	
	private static final long serialVersionUID = -7456005194464997324L;
	private String name;
	private String gender;
	public static int legs = 4;
	
	public Cat(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Cat [name=" + name + ", gender=" + gender + "]";
	}
}
