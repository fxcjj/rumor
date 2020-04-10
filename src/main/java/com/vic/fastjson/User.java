package com.vic.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {

	private Integer id;

	/**
	 * 加了此注解，此字段不参与序列化（不会打印出来）
	 */
	@JSONField(serialize = false)
	private String name;

	private Date create_time;
	
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public User() {
	}
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", create_time=" + create_time + "]";
	}

}
