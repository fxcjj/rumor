package com.vic.bitshift;

/**
 * 位移
 * 1、<< 左移运算符，高位舍弃，低位补0。 如：n << num，相当n * 2^num
 * 2、>> 是带符号右移，若左操作数是正数，则高位补0，若左操作数是负数，则高位补1
 * 3、>>> 是无符号右移，无论是正数还是负数，都在高位补0
 * 
 * 以上三种移位符号中左操作数可以有：byte, short, int, long, char
 * 
 * git日志参考路径
 * note/java/bit-shift-operator.txt
 * 
 * @author Victor
 */
public class ShiftTest {

	public static void main(String[] args) {
		
//		leftShift();
		
//		signedRightShift();
		
//		unsignedRightShift();
		
//		swap();
		
		String aa = "01111111111111111111111111111101";
		
		//二进制转换为十进制
//		System.out.println(Integer.valueOf(a, 2)/2);
		
		//打印是补码
//		System.out.println(Integer.toBinaryString(-10));
		
		System.out.println(2 << -1);

//		System.out.println(1 << 31);
//		System.out.println(1 << -1);
		
		
//		System.out.println(b^b^a); //0^a
		
//		int m = -1;
//		System.out.println(m >> 31); //算出符号位，0为正，-1为负
		
		int a = -5;
		System.out.println();
		System.out.println((a^-1)); //-1的补码形式全为1
		
		System.out.println(Integer.toBinaryString(-1));
	}

	/**
	 * 不使用临时变量变换两个数
	 */
	private static void swap() {
		int a = 3;
		int b = 4;
		a = a ^ b; //a异或b得到结果
		b = a ^ b; //结果a异或b，得到原来的a
		a = a ^ b; //结果a异或现在的b（是原来的a），得到原来的b
		
//		System.out.println(a); //4
//		System.out.println(b); //3
	}
	
	/**
	 * >>>运算符
	 */
	private static void unsignedRightShift() {
		int positive = 5;
		System.out.println(positive >>> 1); //2
		System.out.println(positive >>> 2); //1
		
		int negative = -6;
		System.out.println(negative >>> 1); //2147483645
		System.out.println(negative >>> 2); //1073741822
	}

	/**
	 * >>运算符
	 */
	private static void signedRightShift() {
		int num = 5;
		
		int a = num >> 1;
		int b = num >> 2;
		
		System.out.println(num + " >> 1 = " + a); //2
		System.out.println(num + " >> 2 = " + b); //1
		
		int num1 = -6;
		int c = num1 >> 1;
		int d = num1 >> 2;
		System.out.println(num1 + " >> 1 = " + c); //-3
		System.out.println(num1 + " >> 2 = " + d); //-2
	}
	
	/**
	 * <<运算符
	 */
	private static void leftShift() {
		int num = 5;
		int a = num << 1;
		int b = num << 2;
		
		System.out.println(num + " << 1 = " + a);
		System.out.println(num + " << 2 = " + b);
		
		int num1 = -6;
		int c = num1 << 1;
		int d = num1 << 2;
		System.out.println(num1 + " << 1 = " + c);
		System.out.println(num1 + " << 2 = " + d);
	}

}
