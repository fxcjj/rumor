package com.vic.primitive;

/**
char和byte区别
char
	表示的是单引号内的单个字符
	是字符数据类型、是无符号型的、占2个字节（Unicode码）
	大小范围是0—65535
	char是一个16位二进制的Unicode字符，java用char表示一个字符
	
byte
	是字节数据类型 、是有符号型的、占1个字节
	大小范围为-128—127

 */
public class CharTest2 {

	public static void main(String[] args) {
		/**
		 无符号型的，可以表示一个整数，不能表示负数；而byte是有符号型的，可以表示-128—127 的数
		 */
		char c1 = (char)-3; //char不能识别负数，必须强制转换否则报错，即使转换之后，也无法识别
		char c2 = 65535; //为65536时报错
		System.out.println(c1); //?
		System.out.println(c2); // 
		
		
		byte b1 = 1;
		byte b2 = -1;
		byte b3 = 127; //为128时报错
		byte b4 = -128; //为-129时报错
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		
		/**
		 char可以表中文字符，byte不可以
		 */
		char e1 = '中', e2 = '国';  
		byte f= (byte) '中'; //必须强制转换否则报错  
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(f);
		
		/**
		 char、byte、int对于英文字符，可以相互转化
		 */
		byte g = 'b';   //b对应ASCII是98  
		char h = (char) g;
		char i = 85;    //U对应ASCII是85  
		int j = 'h';    //h对应ASCII是104  
		System.out.println(g);  
		System.out.println(h);  
		System.out.println(i);  
		System.out.println(j);  
	}

}
