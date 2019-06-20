package com.vic.funny;

/**
 * 值传递分为二种
 * 	1) 值传递
 * 	2) 引用传递
 * java中只有值传递！！！
 *
 */
public class PassByValueTest {

	String str = new String("good");
	StringBuilder sb = new StringBuilder("good");
	
	char [] c = {'a', 'b', 'c'};

	public static void main(String[] args) {
		PassByValueTest e = new PassByValueTest();
		e.change(e.str, e.c);
		System.out.println(e.str);
		System.out.println(e.c);
		
		e.change1(e.sb, e.c);
		System.out.println(e.sb);
		System.out.println(e.c);
		
	}
	
	public void change(String str, char[] c) {
		str.concat("1");
		c[0] = 'g';
	}
	
	public void change1(StringBuilder sb, char[] c) {
		sb.append("man");
		c[0] = 'g';
	}
	
	

}
