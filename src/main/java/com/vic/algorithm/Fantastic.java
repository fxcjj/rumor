package com.vic.algorithm;

/**
 * 
 * @author Victor
 *
 */
public class Fantastic {
	
	
	public static void main(String[] args) throws Exception {


		testCase(2);

		// 测试组合boolean
//		testCombinationBoolean();
	}

	private static void testCase(int i) {
		int result = 0;
		switch (i) {
			case 1:
				result = result + i;
			case 2:
				result = result + i * 2;
			case 3:
				result = result + i * 3;
		}
		System.out.println(result);
	}

	/**
	 * 测试组合boolean
	 */
	public static void testCombinationBoolean() {

		boolean a = true;
		boolean b = true;

		/**
		 * true true
		 * true false
		 * false false
		 * false true
		 */
		if(!a && !b) {
			System.out.println("执行了语句: !a && !b");
		} else if(a && b) {
			System.out.println("执行了语句: a && b");
		} else if(a) {
			System.out.println("执行了语句: a");
		} else if(b) {
			System.out.println("执行了语句: b");
		} else {
			System.out.println("执行了语句: else");
		}
	}
	
}
