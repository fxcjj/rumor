package com.vic.funny;

/**
 * 求和的两种方式
 * 1. 递归
 * 2. 求和公式
 * @author Victor
 */
public class SumTest {

public static void main(String[] args) {
		
//		test01();
		
		test02();
	}

	private static void test02() {
		try {
			test03();
		} catch (Exception e) {
			System.out.println("test02, happen exception");
		}
		
	}
	

	private static void test03() {
		try {
			int a = 3;
			System.out.println(a/0);
		} finally {
			System.out.println("test03, finally");
		}
		
	}
	

	/**
	 * 求1~100的和
	 */
	private static void test01() {
		int a = 100;
		
		//method 1
		int sum = plus(a);
		
		System.out.println(sum);
		
		
		//method 2
		sum = a*(a+1)/2; //时间复杂度为O(1)
		
		System.out.println(sum);
	}

	private static int plus(int a) {
		if(a == 0) {
			return 0;
		}
		return a + plus(a - 1);
	}
	
}
