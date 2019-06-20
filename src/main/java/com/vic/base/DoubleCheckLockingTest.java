package com.vic.base;

public class DoubleCheckLockingTest {
	
	private  volatile static DoubleCheckLockingTest instance;
	
	private DoubleCheckLockingTest() {
	}
	
	public static DoubleCheckLockingTest getInstance() {
		if(instance == null) { //1行
			synchronized(DoubleCheckLockingTest.class) {
				/**
				 * 分解为3行伪代码
				 * memory = allocate(); //分配内存空间
				 * initInstance(memory); //初始化对象
				 * instance = memory; //将instance指向内存地址
				 * 
				 * 这三行代码会指令重排序，如：
				 * (1) memory = allocate(); //分配内存空间
				 * (2) instance = memory; //将instance指向内存地址
				 * (3) initInstance(memory); //初始化对象
				 * 如果执行到(2)时，恰巧有线程执行到1行，那么就会进入。
				 * 解决方案
				 * 	使用volatile防止指令重排序
				 * 
				 */
				instance = new DoubleCheckLockingTest();
			}
		}
		return instance;
	}
	
}
