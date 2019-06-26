package com.vic.io;

import java.io.*;

/**
 * 七
 * FileInputStream, FileOutputStream测试
 * 
 * @author Victor
 */
public class FileStreamTest {
    private static final String FILE_NAME = "d:/coupling.txt";
    public static void main(String[] args) throws Exception {
        testWrite();
        testRead();
    }
    
    private static void testRead() throws Exception {
        File file = new File(FILE_NAME);
        
        //方法1
        FileInputStream  fis = new FileInputStream(file);
        
        //方法2
        FileInputStream  fis1 = new FileInputStream(FILE_NAME);
        
        //方法3
        FileDescriptor fd = fis1.getFD();
        FileInputStream  fis2 = new FileInputStream(fd);
        
        //Reads a byte of data from this input stream. This method blocks if no input is yet 
        int dataByte = fis.read();
        //translate a byte to character, such as 97->a
        char c = (char)dataByte;  
        System.out.println("dataByte = "+dataByte); 
        System.out.println("c = " + c);
        
        //跳过4个字节
        fis.skip(4); //cdef
        
        byte[] buf = new byte[10];  
        fis.read(buf, 0, buf.length);  
        System.out.println("buf = "+(new String(buf))); 
        
        BufferedInputStream bufIn = new BufferedInputStream(fis2);
        
        // 读取一个字节
        char c2 = (char)bufIn.read();  
        System.out.println("c2="+c2);
        fis.close();
        fis1.close();
        fis2.close();
    }

    private static void testWrite() throws Exception {
        File file = new File(FILE_NAME);
        //默认为非追加模式
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        ps.print("abcdefghijklmnopqrstuvwxyz");
        ps.close();
        
        //使用追加模式
        FileOutputStream fos1 = new FileOutputStream(file, true);
        PrintStream ps1 = new PrintStream(fos1);
        ps1.print("123");
        ps1.close();
        
    }
    
}
