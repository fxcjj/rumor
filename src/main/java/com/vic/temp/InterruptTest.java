package com.vic.temp;

public class InterruptTest {

	public static void main(String[] args) {
		
		Thread.currentThread().interrupt();
		System.out.println(Thread.currentThread().isInterrupted());
		
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("a");
			
			System.out.println(Thread.currentThread().isInterrupted());
			
			
		}
		
		System.out.println(Thread.currentThread().isInterrupted());
		
		System.out.println(System.currentTimeMillis() - start); //尚未休眠就被中断，必定远远小于2秒
		System.out.println("b");
	}

}
