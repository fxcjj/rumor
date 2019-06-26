package com.vic.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class ReturnFinallyTest {

	public static void main(String[] args) {
		
//		System.out.println(getMap().get("key"));
		System.out.println(test4());
	}
	
	private static Map<String, String> getMap() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "init");
		try {
			map.put("key", "try");
			return map;
		} catch (Exception e) {
			map.put("key", "catch");
		} finally {
			map.put("key", "finally"); //起作用了
			map = null; //没有作用
		}
		return map;
	}
	
	/*
	 * test3 try block
		test3 finally block
		b > 20, a = 50
		50
		 如果finally语句中没有return语句覆盖返回值，那么原来的返回值可能因为finally里的修改而改变也可能不变。
	 */
	private static int test4() {
		int b = 20;
		try {
			System.out.println("test3 try block");
			return b += 30;
		} catch (Exception e) {
            System.out.println("catch block");
        }  finally {
			System.out.println("test3 finally block");
			if(b > 20) {
				System.out.println("b > 20, a = " + b);
			}
			b = 300;
		}
		return 200;
	}
	
	/*
	 * output:
	 * test3 try block
		test3 finally block
		b > 20, a = 50
		200
		这说明finally里的return直接返回了，就不管try中是否还有返回语句
	 */
	private static int test3() {
		int b = 20;
		try {
			System.out.println("test3 try block");
			return b += 30;
		} catch (Exception e) {
            System.out.println("catch block");
        }  finally {
			System.out.println("test3 finally block");
			if(b > 20) {
				System.out.println("b > 20, a = " + b);
			}
			return 200;
		}
	}
	

	/*
	 * output:
	 * test2 try block
	 * entering test21
	 * test2 finally block
	 * a
	 */
	private static String test2() {
		try {
			System.out.println("test2 try block");
			return test21();
		} finally {
			System.out.println("test2 finally block");
		}
	}

	private static String test21() {
		System.out.println("entering test21");
		return "a";
	}

	/*
	 * output:
	 * try
	 * finally
	 * a > 1, a = 2
	 * 2
	 * 说明return语句已经执行了再去执行finally语句，不过并没有直接返回，而是等finally语句执行完了再返回结果。
	 */
	private static int test1() {
		
		int a = 0;
		try {
			System.out.println("try");
//			System.exit(0);
			
			return  a += 2;
		} catch (Exception e) {
			System.out.println("catch");
		} finally {
			System.out.println("finally");
			if(a > 1) {
				System.out.println("a > 1, a = " + a);
			}
		}
		return 444;
	}

}
