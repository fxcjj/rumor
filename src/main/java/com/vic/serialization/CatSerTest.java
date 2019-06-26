package com.vic.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CatSerTest {
	
	public static void main(String[] args) {
		//序列化
		testSerial();
		
		//反序列化
		testDeSerial();
		
	}
	
	//序列化
	public static void testSerial() {
		try {
			Cat cat = new Cat("rat", "m");
			//创建输出流对象
			FileOutputStream fos = new FileOutputStream("E:/cat.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cat);
			oos.close();
			
			//修改static变量
			cat.legs = 5;
			
			//创建输入流对象
			FileInputStream fis = new FileInputStream("E:/cat.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Cat cat2 = (Cat)ois.readObject();
			ois.close();
			
			System.out.println(cat2.legs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//反序列化
	public static void testDeSerial() {
		try {
			//创建输入流对象
			FileInputStream fis = new FileInputStream("E:/cat.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Cat cat2 = (Cat)ois.readObject();
			ois.close();
			
			System.out.println(cat2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
