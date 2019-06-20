package com.vic.algorithm;

/**
 * 
 * @author Victor
 *
 */
public class Test {
	
	
	public static void main(String[] args) {
//		test1();
		test2();
		
	}

	private static void test2() {
		/*for(int i = 800; i < 1050; i++) {
			System.out.println(Math.pow(i, 3) + "\t" + Math.pow(2, i));
		}*/
		
		
//		1000000000
		System.out.println(Math.pow(1020, 3) + "\t" + Math.pow(2, 1020));
		
		double sum = 2;
		for(int i = 1; i <= 100; i++) {
			sum = sum * i;
		}
		System.out.println("sum: " + sum);
		
		
		
	}

	private static void test1() {
		int sum = 0;
		int n = 100;
		for(int i = 1; i <= n; i++) { //执行了n+1次，最后一次判断跳出也算一次
			sum = sum + i; //执行了n次
		}
		System.out.println(sum);
		
		
		sum = (1+n) * n/2;
 		System.out.println(sum);
		

	}
	
	
}
