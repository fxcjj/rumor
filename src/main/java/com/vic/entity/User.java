package com.vic.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -3965824309755073363L;

	private String username;

	private String psw;

	private String age;
	
	private Integer seq_no;
	
	public Integer getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(Integer seq_no) {
		this.seq_no = seq_no;
	}

	private UserType userType;
	
	public User() {
		
	}
	
	public User(String username, String psw) {
		super();
		this.username = username;
		this.psw = psw;
	}
	
	public User(String username, String psw, Integer seq_no) {
		super();
		this.username = username;
		this.psw = psw;
		this.seq_no = seq_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getAge() {
		return age;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setAge(String age) {
		this.age = age;
	}

	enum UserType {
		ADMIN, SUPERADMIN, GENERAL
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", psw=" + psw + ", age=" + age + ", seq_no=" + seq_no + ", userType="
				+ userType + "]";
	}

	
}
