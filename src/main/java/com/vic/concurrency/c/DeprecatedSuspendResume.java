package com.vic.concurrency.c;
/**
 * 
 * @author Victor
*/
public class DeprecatedSuspendResume implements Runnable {

	/**
	 * volatile关键字，表示该变量可能在被一个线程使用的同时，被另一个线程修改
	 */
	private volatile int firstVal;
	private volatile int secondVal;

	/**
	 * 判断两者是否相等
	 * @return
	 */
	public boolean areValuesEqual() {
		return firstVal == secondVal;
	}
	
	@Override
	public void run() {
		
		try {
			firstVal = 0;
			secondVal = 0;
			workMethod();
		} catch (InterruptedException e) {
			System.out.println("interrupted while in workMethod()");
		}
		
	}
	
	public void workMethod() throws InterruptedException {
		int val = 1;
		while(true) {
			stepOne(val);
			stepTwo(val);
			val++;
			// 再次循环先休眠200毫秒
			Thread.sleep(200);
		}
	}

	/**
	 * 赋值后，休眠300毫秒，从而使线程有机会在stepOne操作和stepTwo操作之间被挂起
	 */
	public void stepOne(int newVal) throws InterruptedException {
		firstVal = newVal;
		/**
		 * 模拟长时间运行的情况
		 * 如果在此时间段线程被挂起，那么areValuesEqual()为false
		 */
		Thread.sleep(300);
	}
	
	public void stepTwo(int newVal) {
		secondVal = newVal;
	}
	
	
	public static void main(String[] args) {
		
		DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
		Thread t = new Thread(dsr);
		t.start();
		
		// main线程休眠1秒，让t线程有机会执行一段时间
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		for(int i = 0; i < 10; i++) {
			// t线程挂起
			t.suspend();
			System.out.println("dsr.areValuesEqual() = " + dsr.areValuesEqual());
			// t线程恢复
			t.resume();
			
			try {
				// 目的是让workMethod方法运行完毕（firstVal等于secondVal）
				Thread.sleep((long)(Math.random()*2000.0));
			} catch (InterruptedException e) {
			}
		}
		// 退出应用程序
		System.exit(0);
		
	}

}
