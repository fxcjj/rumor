package com.vic.permanent.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserSerTest {
	
	public static void main(String[] args) {
		testSerial();
	}
	
	public static void testSerial() {
		try {
			FileOutputStream fos = new FileOutputStream("E:/user.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new User("u1", "p1"));
			oos.close();
			
			FileInputStream fis = new FileInputStream("E:/user.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			User user = (User)ois.readObject();
			ois.close();
			
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
