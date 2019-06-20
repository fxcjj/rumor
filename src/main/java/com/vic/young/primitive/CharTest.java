package com.vic.young.primitive;

/**
 * char在Java中是16位的，因为Java用的是Unicode
 * 
 * char表示的是单引号内的单个字符
 * char类型表示的是字符，不是字符串
 * char类型必须用单引号来表示，不能用双引号来表示，因此凡是有双引号的都是错误的
 * 
 *  也可以输入字符的Unicode值，Unicode表示法是在值前加前缀 \ u (中间无空格)
 * 字符实际上只是一个16位的无符号整数（小于或者等于65535）
 * 如果要表示一个不能作为字面值输入的字符，可以使用转义字符 char c='\ " '; char d='\n';
 * 换行，新行，水平制表符，退格，双引号和单引号    \b \t \n \f \r \" \'
 * 
 * 
 * 初始化方式：
char c='c'; //字符，可以是汉字，因为是Unicode编码
char c=十进制数，八进制数，十六进制数等等; //可以用整数赋值
char c='\ u数字'; //用字符的编码值来初始化，如：char='\0',表示结束符，它的ascll码是0，这句话的意思和 char c=0 是一个意思。

通常gbk/gb2312是2个字节，utf-8是3个字节。
 * @author Victor
 *
 */
public class CharTest {

	public static void main(String[] args) throws Exception {
		char c1 = 'a'; 
		char ca = '1';
		char cb = '你';
		//char c2 = "a"; //Type mismatch: cannot convert from String to char
		//char c3 = 'hello'; //Invalid character constant
		
		char c4 = '\'';
		char c5 = '\ucafe';
		//char c6 = '\u10100'; //Invalid character constant
		char c7 = '1';
		//char c8 = true; //Type mismatch: cannot convert from boolean to char
		
		System.out.println(c1);
		System.out.println(ca);
		System.out.println(cb);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c7);
		/*output:
		a 	1 	你 	' 	쫾 	1
		*/
		
		System.out.println("=============");
		
		char a = 'a';
		char a1 = 'a';
		int aa = a + a1;
		System.out.println(aa); //194
		
		System.out.println("=============");
		
		String property = System.getProperty("file.encoding");
		System.out.println(property);
		String str = "中";
		byte[] bytes = str.getBytes("gbk"); //default encoding UTF-8（3个字节）
		for(byte b : bytes) {
			System.out.println(b);
		}
		
		System.out.println("============");
		
		char t1 = 'a';
		System.out.println(t1);
		char t2 = 97;
		System.out.println(t2);
		
	}

}
