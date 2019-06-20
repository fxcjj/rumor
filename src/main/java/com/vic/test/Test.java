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
    
	static final int MAXIMUM_CAPACITY = 1 << 30;
	
	long bb;
	private static final int a = 12;
	
	private volatile User user;
	
	public Object getKey() {
		return new Object();
	}
	
	public Object getValue() {
		return new Object();
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof Map.Entry))
			return false;
		Map.Entry e = (Map.Entry)o;
		Object k1 = getKey();
		Object k2 = e.getKey();
		if(k1 == k2 || (k1 != null && k1.equals(k2))) {
			Object v1 = getValue();
			Object v2 = e.getValue();
			if(v1 == v2 || (v1 != null && v1.equals(v2))) {
				return true;
			}
		}
		return false;
	}
	
    public static void main(String[] args) throws Exception {
    	
        //string2Unicode("好");
        
        //unicode2String("\\u597d");
        
//        System.out.println(0x7f);
//        System.out.println(0x20);
        
        //testCEF();
        
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
    	
//    	int a = 1;
//    	int b = 2;
//    	a = a^b;
//    	b = a^b;
//    	a = a^b;
//    	System.out.println(a);
////    	System.out.println(b);
//    	String srcPath = "d:/a/bigpic1.png";
//    	String destPath = "d:/a/dd.png";
//    	
//    	testImage(srcPath, destPath, "png");
//    	System.out.println("done");
    	
//    	Integer a  = 91;
//    	System.out.println(a>90);
    	
//    	System.out.println(System.getProperty("catalina.base"));
//    	System.out.println(System.getProperty("catalina.home"));
//    	System.out.println(System.getProperty("java.io.tmpdir"));
    	
//    	Map<String, Object> map = new HashMap<String, Object>();
    	
//    	int a = 1;
//    	map.put("a", a);
//    	
//    	a = 23432;
//    	map.put("b", a);
//    	
//    	System.out.println(map.get("a"));
//    	System.out.println(map.get("b"));
//    	Test t = new Test();
//    	t.print();
    	
    	/*Map<String, User> map = new HashMap<String, User>();
		User put = map.put("a", new User("u1", "p1"));
		System.out.println(put);
		User put2 = map.put(null, new User("u2", "p2"));
		System.out.println(put2);
		User put3 = map.put(null, new User("u3", "p3"));
		System.out.println(put3);
		
		Set<Entry<String, User>> entrySet = map.entrySet();
		for(Entry<String, User> entry : entrySet) {
			System.out.println(entry.getKey() + ", "+entry.getValue());
		}*/
		/*User u = map.get("a");
		u.setUsername("aa");
		u.setPsw("pppp");*/
//		System.out.println(u);
		
		/*String a = new String("你好ab");
		a.toCharArray();
		
		int count = 3;
		char value[] = new char[count];
		value[0] = 'a';
		value[1] = 'b';
		value[2] = 'c';
		
		int cnt = 3;
		char dst[] = new char[cnt];*/
		/*dst[0] = 'a';
		dst[1] = 'b';
		dst[2] = 'c';*/
		
		/*System.arraycopy(value, 0 + 0, dst, 0, count - 0);
		
		for(char c : dst) {
			System.out.println(c);
		}*/
		
		
    	/*int [][] arr1 = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
    	int [][] arr2 = new int[3][];
    	System.arraycopy(arr1, 0, arr2, 0, arr1.length);
    	
		arr2[2][1] = 999;
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}*/
		
		/*String[] s = {"java", "php", "go", "python"};
		String[] c = new String[6];
		System.arraycopy(s, 0, c, 0, s.length);
		c[2] = "lua";
		list(s);
		list(c);*/
		
		/*int[] aa = {1, 2, 3};
		int[] bb = new int[3];
		System.arraycopy(aa, 0, bb, 0, aa.length);
		
		bb[1] = 32;
		
		for(int a : aa) {
			System.out.print(a+" ");
		}
		System.out.println();
		for(int a : bb) {
			System.out.print(a + " ");
		}*/
    	
    	
    	String b = "b";
    	String c = "c";
    	String d = "d";
    	
    	String cc = "c";
    	
//    	System.out.println(a.hashCode());
//    	System.out.println(b.hashCode());
    	
//    	User user = new User("u1", "p1");
//    	User user1 = new User("u1", "p1");
//    	System.out.println(user.hashCode());
//    	System.out.println(user1.hashCode());
    	
    	
    	Set<String> set = new HashSet<String>();
    	set.add(b);
    	set.add(c);
//    	set.add(d);
//    	set.add(cc);
    	
    	/*Iterator<String> iter = set.iterator();
    	while(iter.hasNext()) {
    		String next = iter.next();
    		System.out.println(next);
    	}*/
    	
//    	System.out.println(1 << 30);
    	
    	for(int i = 0; i < 35; i++) {
    		System.out.println(i + "->" + tableSizeFor(i));
    	}
    	
    }
    
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
//		System.out.println(n); //6
		
        n |= n >>> 2;
//        System.out.println(n); //7

        n |= n >>> 4;
//        System.out.println(n); //7
        
        n |= n >>> 8;
//        System.out.println(n); //7
        
        n |= n >>> 16;
//        System.out.println(n); //7
        
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY ) ? MAXIMUM_CAPACITY : n + 1;
    }
    
    private static void list(String[] c) {
    	for(int i = 0; i < c.length; i++) {
    		System.out.print(c[i]+" ");
    	}
    	System.out.println();
	}

	public void print() {
    	System.out.println(bb);
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
    


	private static void testImage(String srcPath, String destPath, String formate) {
		
		 try {  
	            File file = new File(srcPath);  
	            File destFile = new File(destPath);  
	            if (!destFile.getParentFile().exists()) {
	                destFile.getParentFile().mkdir();  
	            }  
	            BufferedImage src = ImageIO.read(file); // 读入文件  
	            BufferedImage tag = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);  
	            Graphics g = tag.getGraphics();  
	            g.drawImage(src, 0, 0, null); // 绘制缩小后的图  
	            g.dispose();  
	            ImageIO.write(tag, formate, new FileOutputStream(destFile));// 输出到文件流  
	        } catch (IOException e) {  
	            e.printStackTrace();  
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



	//notify必须在锁中
//    private static void testNotify(int i, User u) {
//    	Test.class.notify();
//	}
	
    private static void testLong2Int() {
        long clairvoyant = 2147483648L;
        int in1 = (int) clairvoyant;
    }

    /**
     * 测试转义字符
     */
    private static void testEscapeCharacter() {
    	String u = "\\\\u";
    	System.out.println(u);
    }
    
    /**
     * 将double转换为int
     */
    private static void testDouble2Int() {
        //强制类型转换
        double dd = 20.5;
        int w = (int) dd;
        System.out.println(w); //20
    }

    /**
     * 测试下基本数据类型的取值范围
     */
    private static void testPrimitiveValue() {
        // byte(8bit), short(16bit), int(32), long(64), float(32bit), double(64bit),char(16), boolean 
        //对应的wrapper
        //Byte, Short, Integer, Long, Float, Double, Character, Boolean
        
        System.out.println("Byte max_value = "+Byte.MAX_VALUE);
        System.out.println("Byte min_value = "+Byte.MIN_VALUE);
        
        System.out.println("Short max_value = "+Short.MAX_VALUE);
        System.out.println("Short max_value = "+Short.MIN_VALUE);
        
        System.out.println("Integer max_value = "+Integer.MAX_VALUE);
        System.out.println("Integer max_value = "+Integer.MIN_VALUE);
        
        System.out.println("Long max_value = "+Long.MAX_VALUE);
        System.out.println("Long max_value = "+Long.MIN_VALUE);
        
        System.out.println("Float max_value = "+Float.MAX_VALUE);
        System.out.println("Float max_value = "+Float.MIN_VALUE);
        
        System.out.println("Double max_value = "+Double.MAX_VALUE);
        System.out.println("Double max_value = "+Double.MIN_VALUE);
        
        System.out.println("Character max_value = "+Character.MAX_VALUE);
        System.out.println("Character max_value = "+Character.MIN_VALUE);
        
        System.out.println("Boolean true = "+Boolean.TRUE);
        System.out.println("Boolean falses = "+Boolean.FALSE);
        /* byte b = -128;
        byte b1 = 127;
        short s = -32768;
        short s1 = 32767;
        int in = -2147483648;
        int in1 = 2147483647;*/
        
        /*byte x = 127;
        byte y = 'a';
        byte z = x + y; //Type mismatch: cannot convert from int to byte
         */
      
        //unsigned
        char ch = 'A';
        char ch1 = 1;
        char ch2 = '好';
        
        char luo = '\u7f57';
        char li = '\u5229';
        char hua = '\u534e';
        
        int pseudo = 1;
        long bbb = pseudo;
        
        byte q = (byte)1320L;
        
       int a = 2147483647;
       float ff = a;
//       System.out.println(ff);
    }

    /**
     * primitive type 转转
     */
    private static void testInt2Byte() {
        System.out.println("Integer.MIN_VALUE = "+Integer.MIN_VALUE); //-2147483648
        System.out.println("Integer.MAX_VALUE = "+Integer.MAX_VALUE); //2147483647
      
        System.out.println("Byte.MAX_VALUE = "+Byte.MAX_VALUE); //127
        System.out.println("Byte.MIN_VALUE = "+Byte.MIN_VALUE); //-128
      
        int e = 127;
        byte r = (byte) e;
        System.out.println(r); //123, 未超过byte[-128,127]范围，所以未取低8位
       
        int t = 255;
        byte y = (byte) t;
        System.out.println(y); //超过byte[-128,127]范围，取低8位
    }
    
    /**
     * unicode 转字符串
     */
    public static void unicode2String(String unicode) {
     
        StringBuffer string = new StringBuffer();
     
        String[] hex = unicode.split("\\\\u");
     
        for (int i = 1; i < hex.length; i++) {
     
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
     
            // 追加成string
            string.append((char) data);
        }
        System.out.println(string.toString());
    }
    
    /**
     * 字符串转换unicode
     */
    public static void string2Unicode(String string) {
     
        StringBuffer unicode = new StringBuffer();
     
        for (int i = 0; i < string.length(); i++) {
     
            // 取出每一个字符
            char c = string.charAt(i);
     
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        System.out.println(unicode.toString());
    }
    
    /**
     * 打印不同cef下的字节长度
     * Character Encoding Form
     */
    private static void testCEF() {
        String a = "你好";
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

	private static void testxy() {
		int x = 91, y = 100;
		int count = 0;
		while (y > 0) {
			count++;
			if (x > 100) {
				x = x - 10;
				y--;
			} else
				x++;
		}

		// System.out.println(count);
		int n = 3;
		int xx = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= i; j++)
				for (int k = 1; k <= j; k++)
					xx++;
		System.out.println(xx);
	}

	static String change(String str) {
		str = "welcome";
		return str;
	}

	private static StringBuffer disposeUpperCase(String a) {
		StringBuffer sb = new StringBuffer();
		String[] split = a.split(",");
		for (String s : split) {
			int ind = s.indexOf("_");
			String sub = s.substring(ind + 1, ind + 2);
			String replace = s.replace("_" + sub, sub.toUpperCase());
			sb.append(replace + ",");
		}
		return sb;
	}

	private static void object2Map(Class<?> clazz) {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			try {
				map.put(field.getName(), field.get(clazz));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(map);
	}

	private static void testStackTrace() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		for (StackTraceElement ste : stackTrace) {
			System.out.println(ste);
		}
	}

	private static void testReplace() {
		String a = "aaa";
		String replace = a.replace("aa", "b");
		System.out.println(replace);
	}

	private static void printList() {
		List<User> u1 = new ArrayList<User>();
		u1.add(new User("u1", "p1"));
		u1.add(new User("u2", "p2"));

		List<User> u2 = new ArrayList<User>();
		u2.add(new User("u3", "p3"));
		u2.add(new User("u4", "p4"));

		List<User> u3 = new ArrayList<User>();
		u3.add(new User("u4", "p4"));
		u3.add(new User("u5", "p5"));

		u2.addAll(u3);
		u1.addAll(u2);
		for (User u : u1) {
			System.out.println(u.getUsername());
		}

	}


	private static void test2() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 开始时间
		String startTimeStr = "2016-05-18 00:00:00";
		long startTime = sdf.parse(startTimeStr).getTime();
		System.out.println(startTime);

		String endTimeStr = "2016-05-19 00:00:00";
		long endTime = sdf.parse(endTimeStr).getTime();
		System.out.println(endTime);

		Date startDate = new Date(startTime);

		Date endDate = new Date(endTime);
		System.out.println(startDate);
		System.out.println(endDate);
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
