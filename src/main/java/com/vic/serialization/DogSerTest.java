package com.vic.serialization;

import java.io.*;

public class DogSerTest {
	
	public static void main(String[] args) {
		testSerial1();
		testSerial2();
	}
	
	public static void testSerial1() {
		try {
			Dog d = new Dog("d1", "red");
			FileOutputStream fos = new FileOutputStream("E:/dog.ser");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			//试图将对象两次写入文件
			out.writeObject(d);
			out.flush();
			System.out.println(new File("E:/dog.ser").length());
			out.writeObject(d);
			out.close();
			System.out.println(new File("E:/dog.ser").length());
			
			
			FileInputStream fis = new FileInputStream("E:/dog.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			//从文件依次读出两个文件
			Dog c1 = (Dog)ois.readObject();
			Dog c2 = (Dog)ois.readObject();
			ois.close();
			//判断两个引用是否指向同一个对象
			System.out.println(c1 == c2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testSerial2() {
		try {
			Dog d = new Dog("d1", "red");
			FileOutputStream fos = new FileOutputStream("E:/dog.ser");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			//试图将对象两次写入文件
			//d.setColor("gray");
			d.a = 1;
			out.writeObject(d);
			out.flush();
			//d.setColor("green");
			d.a = 2;
			System.out.println(new File("E:/dog.ser").length());
			out.writeObject(d);
			out.close();
			System.out.println(new File("E:/dog.ser").length());
			
			
			FileInputStream fis = new FileInputStream("E:/dog.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			//从文件依次读出两个文件
			Dog c1 = (Dog)ois.readObject();
			Dog c2 = (Dog)ois.readObject();
			ois.close();
			//判断两个引用是否指向同一个对象
			//System.out.println(c1.getColor());
			//System.out.println(c2.getColor());
			System.out.println(c1.a);
			System.out.println(c2.a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
