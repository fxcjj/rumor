package com.vic.concurrency.b;
/**
 * 待决中断
 * 无参数时
 * 		线程不会被中断，休眠2000毫秒，最终输出的时间差距应该在2000毫秒附近
 * 有参数时
 * 		线程中断，当调用sleep()方法抛出异常，最终输出的时间差距应该远小于2000毫秒
 * @author Victor
*/
public class PendingInterrupt2 {
	public static void main(String[] args) {
		// 如果输入了参数，则在main线程中中断当前线程（即main线程）
		if(args.length > 0) {
			Thread.currentThread().interrupt();
		}
		
		// 获取当前时间
		long startTime = System.currentTimeMillis();
		
		try {
			Thread.sleep(2000);
			System.out.println("was not interrupted");
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("was interrupted");
		}
		
		// 计算中间代码执行的时间
		System.out.println("elapsedTime = " + (System.currentTimeMillis() - startTime));
	}
}
