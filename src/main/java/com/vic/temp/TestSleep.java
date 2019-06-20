package com.vic.temp;

public class TestSleep {
	
	public static void main(String[] args) {
		SleepRunnable sr1 = new SleepRunnable();
		Thread t1 = new Thread(sr1);
		t1.start();

		SleepRunnable sr2 = new SleepRunnable();
		Thread t2 = new Thread(sr2);
		t2.start();
		
	}
	
}

class SleepRunnable implements Runnable {
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" in run() - about to sleep for 4s");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" in run() - leaving normally");
	}
	
}