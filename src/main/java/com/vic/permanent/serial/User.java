package com.vic.permanent.serial;

import java.io.*;

public class User implements Externalizable {
	
	private static final long serialVersionUID = 1L;
	private transient String username;
	private String password;
	
	public User() {
		System.out.println("no-arg constructor");
	}

	public User(String username, String password) {
		System.out.println("constructor");
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(username);
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		username = (String)in.readObject();
	}


	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(username);
		out.writeObject(password);
	}
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		username = (String)in.readObject();
		password = (String)in.readObject();
	}
	
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("E:/user.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new User("u1", "p1"));
		oos.close();
		
		FileInputStream fis = new FileInputStream("E:/user.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		User user = (User)ois.readObject();
		ois.close();
		
		System.out.println(user);
	}
}
