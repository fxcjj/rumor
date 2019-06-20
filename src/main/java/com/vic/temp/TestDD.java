package com.vic.temp;

/**
 * java中的sleep()和wait()的区别
 */
public class TestDD {

	public static void main(String[] args) {
		
		Dataa  da = new Dataa();
		
		new Thread(new Thread1(da)).start();
		new Thread(new Thread2(da)).start();
	}

	private static class Thread1 implements Runnable {
		
		Dataa d;
		Thread1(Dataa d) {
			this.d = d;
		}
		
		public void run() {
			synchronized (TestDD.class) {
				d.i = 100;
				try {
					TestDD.class.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("d.i = "+d.i);
			}
		}
	}

	private static class Thread2 implements Runnable {
		Dataa d;
		Thread2(Dataa d) {
			this.d = d;
		}
		
		public void run() {
			synchronized (TestDD.class) {
				TestDD.class.notify();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				d.i = 200;
				System.out.println("d.i = "+d.i);
			}
		}
	}
}

class Dataa {
	int i;
}