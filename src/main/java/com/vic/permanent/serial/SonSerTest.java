package com.vic.permanent.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SonSerTest {
	
	public static void main(String[] args) {
		testSer();
		
		testDeSer();
		
	}
	
	public static void testSer() {
		try {
			Father f = new Father();
			f.setUsername("f1");
			f.setGender("m");
			f.setAge(31);
			
			
			Son s = new Son();
			s.setPetName("pet1");
//			s.setUsername("s1");
//			s.setGender("m");
//			s.setAge(11);
			//s.setFather(f);
			FileOutputStream fos = new FileOutputStream("E:/son.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s);
			oos.close();
			
			FileInputStream fis = new FileInputStream("E:/son.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Son s1 = (Son)ois.readObject();
			ois.close();
			
			System.out.println(s1.getPetName());
			//System.out.println(s1.getUsername());
			//System.out.println(s1.getGender());
			//System.out.println(s1.getAge());
			System.out.println(s1.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testDeSer() {
		try {
			FileInputStream fis = new FileInputStream("E:/son.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Son c = (Son)ois.readObject();
			ois.close();
			
			System.out.println(c.getUsername());
			System.out.println(c.getGender());
			System.out.println(c.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
