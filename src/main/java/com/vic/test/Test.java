package com.vic.test;

import com.vic.entity.User;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Test {

	
    public static void main(String[] args) throws Exception {
    	
        testCEF();
        
        //testString2Byte();
        
//        testByte();
        
        //testPrimitiveValue();
        
       //testDouble2Int();
        
       //testInt2Byte();
       
       //testLong2Int();
       
       //testEC();
        
//        testCol();
        
//        testUncheckedException();
        
//    	testEscapeCharacter();
        
//    	int a = testTry();
//    	System.out.println(a);

    	
    }


    /**
     * 会出现这个异常
     * Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at cn.clairvoyant.test.Test.main(Test.java:87)
     */
    public static void testConcurrentModificationException() {
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(2);
    	list.add(3);
    	list.add(5);
    	
    	for(Integer item : list) {
    		if(item == 2) {
    			list.remove(item);
    		}
    	}
    }
    

	private static int testTry() {
		int i = 1;
		try {
			return i++;
		} catch (Exception e) {
			
		} finally {
			i++;
			return i;
		}
	}



    /**
     * 打印不同cef下的字节长度
     * Character Encoding Form
     */
    private static void testCEF() {
        String a = "你";
        String b = "g";
        String c = "*";
        String d = "2";
        System.out.println(a.getBytes().length); //UTF-8时，长度为3。 GBK时，长度为2
        System.out.println(b.getBytes().length); //UTF-8时，长度为1。 GBK时，长度为1
        System.out.println(c.getBytes().length); //UTF-8时，长度为1。 GBK时，长度为1
        System.out.println(d.getBytes().length); //UTF-8时，长度为1。 GBK时，长度为1
    }

    /**
     * 打印字符的字节
     */
    private static void testString2Byte() {
        //当此字符串不能使用默认的字符集编码时，此方法的行为没有指定。如果需要对编码过程进行更多控制，则应该使用 CharsetEncoder 类。
        String str = "你好";
        String str1 = "a";
        byte[] bytes = str.getBytes();
        for(byte b : bytes) {
            System.out.println(b);
        }
        
        byte[] bytes1 = str1.getBytes();
        for(byte b : bytes1) {
            System.out.println(b);
        }
    }

    private static void testByte() {
        int a = 0x2f;//小写十六进制（等价于0x002f）  
        System.out.println(Integer.toBinaryString(a));

        int b = 0x2F;//大写十六进制  
        System.out.println(Integer.toBinaryString(b));

        int c = 10;//标准十进制  
        System.out.println(Integer.toBinaryString(c));

        int d = 010;//以零开头，表示八进制  
        System.out.println(Integer.toBinaryString(d));

        char e = 0xff;//char为2个字节，16位
        byte f = 0xf;//byte为8位  
        short g = 0xff;//short为2个字节，16位  
        System.out.println(Integer.toBinaryString(e));
        System.out.println(Integer.toBinaryString(f));
        System.out.println(Integer.toBinaryString(g));
    }
    
    private static int testReturn() {
		int i = 1;
		try {
			i = 2/0;
			return i++;
		}catch(Exception e) {
			return 5;
		} finally {
			System.out.println("finally");
			i = 7;
		}
		
	}

	private static void testStackTrace() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		for (StackTraceElement ste : stackTrace) {
			System.out.println(ste);
		}
	}



	private static void test1() {
		/**
		 * Returns the number of milliseconds since January 1, 1970, 00:00:00
		 * GMT represented by this <tt>Date</tt> object.
		 *
		 * @return the number of milliseconds since January 1, 1970, 00:00:00
		 *         GMT represented by this date.
		 */
		long time = new Date().getTime();
		System.out.println(time);

		String a = "a" + "\r\n1";
		String b = "b" + "\r2";
		String c = "c" + "\n2";
		/**
		 * \n\r do not match any platform, so it is considered as \n and \r, so
		 * there are two new lines.
		 */
		String d = "d" + "\n\r2";
		System.out.println("--------------------");
		System.out.println(a);
		System.out.println("--------------------");
		System.out.println(b);
		System.out.println("--------------------");
		System.out.println(c);
		System.out.println("--------------------");
		System.out.println(d);
		System.out.println("--------------------");

		System.out.println("abc\tdef");

		int position = 0;
		String sessionId = "0234aB_";
		int index = 0;
		for (; index < sessionId.length(); index++) {
			if (sessionId.charAt(index) >= 48 && sessionId.charAt(index) <= 57) {
				position = sessionId.charAt(index) - '0';
				break;
			}
		}

		System.out.println(position);

	}

}
