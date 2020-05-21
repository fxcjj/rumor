package com.vic.concurrency.a;
/**
 * 三个线程共同执行一个任务，有可能会出现资源竟争的问题，导致数据不正确！
 * @author Victor
*/
public class RunnableDemo {
	public static void main(String[] args) {
		/**
		 *  三个Thread共同执行一个Runnable对象中的代码
		 *  ticket可能会出现<=0的情况
		 */
		MyThread1 mt = new MyThread1();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
	}
}

class MyThread1 implements Runnable {

	private int ticket = 5;

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			// com.vic.concurrency.a.MyThread1@4cdf4fcb 同一个对象
			synchronized (this) {
				if(ticket > 0) {
					/**
					 * 线程休眠500毫秒，可能有多个线程可能到这里了，
					 * 然后打印ticket可能会出现-1的情况
					 * 这种情况的出现是由于:
					 * 一个线程在判断ticket为1>0后，还没有来得及减1，另一个线程已经将ticket减1，变为了0，
					 * 那么接下来之前的线程再将ticket减1，便得到了-1。
					 *
					 * ticket--不是原子操作
					 * 分为三个步骤：
					 * 1) getfield
					 * 2) iadd
					 * 3) putfield
					 */

					/*
					第1次执行
					Thread[Thread-0,5,main], 1590041881181, ticket = 5
					Thread[Thread-2,5,main], 1590041881181, ticket = 3
					Thread[Thread-2,5,main], 1590041881181, ticket = 2
					Thread[Thread-1,5,main], 1590041881181, ticket = 4
					Thread[Thread-2,5,main], 1590041881181, ticket = 1
					 */
					/*
					第2次执行
					Thread[Thread-0,5,main], 1590042681889, ticket = 5
					Thread[Thread-2,5,main], 1590042681889, ticket = 3
					Thread[Thread-1,5,main], 1590042681889, ticket = 4
					Thread[Thread-2,5,main], 1590042681889, ticket = 1
					Thread[Thread-0,5,main], 1590042681889, ticket = 2
					 */
					/*
					两次输出顺序并不是54321，这是因为线程执行的时机难以预测
					 */
					try {
						Thread.sleep(500);
						System.out.println(Thread.currentThread() + ", " + System.currentTimeMillis() + ", ticket = " + ticket--);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
	}
	
}
