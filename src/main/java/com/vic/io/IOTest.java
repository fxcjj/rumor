package com.vic.io;

import java.io.File;
import java.io.FileInputStream;

public class IOTest {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("d:/a.txt"));
        //printBytes(fis);
        byte[] buf = new byte[2];
        int r;
        while((r = fis.read(buf)) != -1) {
            System.out.println(new String(buf, "GBK"));
        }
        
        //编码是跟着设置project属性走的
//        System.out.println(Charset.defaultCharset());
//        System.out.println(System.getProperty("file.encoding"));
        
        String str = "a";
        byte[] bytes = str.getBytes();
        System.out.println("the number of byte: " + bytes.length);
        for(byte b : bytes) {
            System.out.println(b+", "+getBit(b));
        }
    }
    
    private static void printBytes(FileInputStream fis) throws Exception {
        int b0 = fis.read();
        int b1 = fis.read();
        int b2 = fis.read();
        int b3 = fis.read();
        int b4 = fis.read();
        int b5 = fis.read();
        int b6 = fis.read();
        int b7 = fis.read();
        int b8 = fis.read();
        System.out.println("b0 = "+b0+", char = "+(char)b0);
        System.out.println("b1 = "+b1+", char = "+(char)b1);
        System.out.println("b2 = "+b2+", char = "+(char)b2);
        System.out.println("b3 = "+b3+", char = "+(char)b3);
        System.out.println("b4 = "+b4+", char = "+(char)b4);
        System.out.println("b5 = "+b5+", char = "+(char)b5);
        System.out.println("b6 = "+b6+", char = "+(char)b6);
        System.out.println("b7 = "+b7+", char = "+(char)b7);
        System.out.println("b8 = "+b8+", char = "+(char)b8);
    }

    public static String getBit(int b) {
        return Integer.toBinaryString(b);
    }
}
