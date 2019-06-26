package com.vic.io;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 九
 * FileDescriptor测试
 * 
 * @author Victor
 */
public class FileDescriptorTest {
    private static final String TEXT = "hello~";
    private static final String FILE_NAME = "d:/fd.txt";
    public static void main(String[] args) throws Exception {
        testWrite();
        testRead();
        testStandFD();
    }

    /**
     * 通过两种方式读取
     * 1)文件名
     * 2)FileDescriptor对象
     */
    private static void testRead() throws Exception {
        FileInputStream fis = new FileInputStream(FILE_NAME); 
        FileDescriptor fdIn = fis.getFD(); 
        FileInputStream fis1 = new FileInputStream(fdIn);
        System.out.println("fis.read():"+(char)fis.read());  
        System.out.println("fis1.read():"+(char)fis1.read());  
        if (fdIn!=null)  
            System.out.printf("fdIn: (%s) is %s\n", fdIn, fdIn.valid());  
        fis.close();
        fis1.close();
    }

    /**
     * 使用二种方式创建FileOutputStream
     * 1)文件名
     * 2)FileDescriptor对象
     * @throws Exception 
     */
    private static void testWrite() throws Exception {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        FileDescriptor fd = fos.getFD();
        
        //本质是fos
        FileOutputStream fos1 = new FileOutputStream(fd);
        
        fos.write('A'); //写入A
        fos1.write('a'); //写入a
        
        if(fd != null)
            System.out.printf("fd: (%s), is %s\n", fd, fd.valid());
        
        fos.close();
        fos1.close();
        
    }

    /**
     * 等价于System.out.println(TEXT);
     */
    private static void testStandFD() {
        PrintStream ps = new PrintStream(new FileOutputStream(FileDescriptor.out));
        ps.println(TEXT);
        ps.close();
    }
}
