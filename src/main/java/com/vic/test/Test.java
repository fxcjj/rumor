package com.vic.test;

import com.alibaba.fastjson.JSON;
import com.vic.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class  Test {

	
    public static void main(String[] args) throws Exception {



		List<User> lista = new ArrayList<>();
		lista.add(new User("u1", "p1"));
		lista.add(new User("u2", "p1"));
		lista.add(new User("u3", "p1"));


		String pp = "p1";


		long count = lista.stream().filter(p -> !StringUtils.equals(p.getPsw(), pp)).count();

//		System.out.println(count);



		List<User> result = lista.stream().map(user ->{
			User vo = new User();
			vo.setUsername(user.getUsername());
			return vo;
		}).collect(Collectors.toList());


		System.out.println(JSON.toJSONString(result));





		Float a = 0.0F;
		Float b = a * 100;
//		System.out.println(b);


		byte aa = 1;
		Byte bb = 0;
//		System.out.println(aa == bb);
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("code", "1243");
//		System.out.println(jsonObject.toJSONString());



/*
		new JSONObject().put("code", "");
		JSONArray jsonArray = new JSONArray();

		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("code", "1243");
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("code", "546");

		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);

		System.out.println(jsonArray.toJSONString());*/


//		int i = 999;
//		i--;
//		++i;
//		System.out.println(i++);
//		System.out.println(i);



//        testCEF();
        
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

//    	testUrl();

//		System.out.println(test());
	}

	private static int test() {
		try {
			int a = 3/0;
		} catch (Exception e) {
			//1. main方法打印1
			/**
			 * java.lang.ArithmeticException: / by zero
			 * 	at com.vic.test.Test.test(Test.java:65)
			 * 	at com.vic.test.Test.main(Test.java:60)
			 */
			e.printStackTrace();

			//2. main方法打印1
			/**
			 * / by zero
			 */
//			System.out.println(e.getMessage());

			//3. main不打印
			/**
			 * Exception in thread "main" java.lang.ArithmeticException: / by zero
			 * 	at com.vic.test.Test.test(Test.java:65)
			 * 	at com.vic.test.Test.main(Test.java:60)
			 */
//			throw e;
		}
		return 1;
	}

	private static void testUrl() throws UnsupportedEncodingException {
		/**
		 * 编码为UTF-8，每个汉字占三个字节
		 * 为: %E4%B8%BA
		 * 什: %E4%BB%80
		 * 么: %E4%B9%88
		 * 为什么: %E4%B8%BA%E4%BB%80%E4%B9%88
		 *
		 * 编码为GBK，每个汉字占二个字节
		 * 为什么: %CE%AA%CA%B2%C3%B4
		 */
		String originStr = "为什么";
		String encoded = URLEncoder.encode(originStr, "GBK");
		System.out.println(encoded);

		String decoded = URLDecoder.decode(encoded, "GBK");
		System.out.println(decoded);
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
