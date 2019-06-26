package com.vic.fastjson;

import java.util.List;

public class Group {

	private Integer id;
	
	private String name;

	List<User> userList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", userList=" + userList + "]";
	}
	
}
