package com.vic.temp;

public class TestWait {
	
	public static void main(String[] args) {
		WaitRunnable sr1 = new WaitRunnable();
		Thread t1 = new Thread(sr1);
		t1.start();

		WaitRunnable sr2 = new WaitRunnable();
		Thread t2 = new Thread(sr2);
		t2.start();
		
	}
	
}

class WaitRunnable implements Runnable {
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" in run() - before lock");
		synchronized (WaitRunnable.class) {
			System.out.println(Thread.currentThread().getName()+" in run() - about to sleep for 4s");
			try {
				WaitRunnable.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" in run() - leaving normally");
		}
		System.out.println(Thread.currentThread().getName()+" in run() - after lock");
	}
	
}