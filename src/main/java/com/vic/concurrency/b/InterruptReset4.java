package com.vic.concurrency.b;
/**
 * Thread.interrupted()重置了中断标志为false
 * 
 * @author Victor
*/
public class InterruptReset4 {
	public static void main(String[] args) {

		// Thread.interrupted()隐式重置中断状态为false
		System.out.println("point X: Thread.interrupted() = " + Thread.interrupted());

		// 中断自身
		Thread.currentThread().interrupt();

		// 输出中断标志为true，并隐式重置为false
		System.out.println("point Y: Thread.interrupted() = " + Thread.interrupted());

		// 已被上一句隐式重置，所以这里是false
		System.out.println("point Z: Thread.interrupted() = " + Thread.interrupted());
	}
}
