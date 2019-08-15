package com.vic.concurrency.singleton;
/**
 * Initialization-on-demand holder idiom
 * @author Victor
*/
public class Singleton1 {
	
	private Singleton1() {}
	
	private static volatile Singleton1 instance = null;
	
	public static Singleton1 getInstance() {
		if(instance == null) {
			synchronized (Singleton1.class) {
				if(instance == null) {
					instance = new Singleton1();
				}
			}
		}
		return instance;
	}
}
