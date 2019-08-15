package com.vic.concurrency.singleton;

/**
 * 
 * @author Victor
*/
public class Singleton {
	
	private Singleton() {}
	
	private static class SingletonHolder {
		private final static Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
