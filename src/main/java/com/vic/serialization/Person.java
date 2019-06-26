package com.vic.serialization;

import java.io.*;

public class Person implements Serializable {
	
	private static class InstanceHolder {
		private static final Person instance = new Person("victor", 18);
	}
	
	public static Person getInstance() {
		return InstanceHolder.instance;
	}
	
	private static final long serialVersionUID = 1L;
	private String name;
    private Integer age;
	
	public Person() {
		System.out.println("no-arg constructor");
	}

	public Person(String name, Integer age) {
		System.out.println("constructor");
		this.name = name;
		this.age = age;
	}

	private Object readResolve() throws ObjectStreamException {
		return InstanceHolder.instance;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("E:/person.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Person.getInstance());
		oos.close();
		
		FileInputStream fis = new FileInputStream("E:/person.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person newPerson  = (Person)ois.readObject();
		ois.close();
		
		System.out.println(newPerson);
		System.out.println(Person.getInstance() == newPerson);
	}
}
