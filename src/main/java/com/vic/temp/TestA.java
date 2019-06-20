package com.vic.temp;

public class TestA {
	
	private static boolean ready;
	
	private static int number;
	
	private static class ReaderThread extends Thread {
		
		@Override
		public void run() {
			while(!ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
		
	}
	
	public static void main(String[] args) {
		new ReaderThread().start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		number = 23;
		ready = true;
		
	}
	
	
}
