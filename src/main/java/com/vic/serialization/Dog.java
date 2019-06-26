package com.vic.serialization;

import java.io.Serializable;


public class Dog implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String color;
	
	private Integer type;
	
	private String time;
	
	public int a;
	
	public Dog(String name, String color, Integer type, String time) {
		super();
		this.name = name;
		this.color = color;
		this.type = type;
		this.time = time;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	
	public Dog(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
