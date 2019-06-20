package com.vic.algorithm.thoughts.d;

public class MyStack {
	public static void main(String[] args) {
		String a = "123";
		System.out.println(reverse(a));
	}

	private static String reverse(String a) {
		if(a.length() == 1)
			return a;
		return reverse(a.substring(1)) + a.charAt(0);
	}
}
