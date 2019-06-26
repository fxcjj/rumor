package com.vic.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * 十三
 * 
 * 
 * @author victor
 */
public class BufferedOutputStreamTest {

    //对应abcdefghijklmnopqrstuvwxyz
    private static final byte[] arrayLetters = { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68,
            0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76,
            0x77, 0x78, 0x79, 0x7A          };

    public static void main(String[] args) throws Exception {
        
        File file = new File("d:/out.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        //buf的大小为16，即当count>=buf.length时，自动flush
        OutputStream out = new BufferedOutputStream(new FileOutputStream(file), 16);
        
        //写入arrayLetters的0到10位置上的字节到输出流
        /**
         * 当len>=buf.length时，out.write(arrayLetters, 0, len)
         */
        out.write(arrayLetters, 0, 20);
        //写入换行到输出流
        out.write('\n');
        
        //将缓冲区的数据写入到输出流
//        out.flush();
        
        readUserInput();
        
        out.close();
        
    }

    private static void readUserInput() {
        System.out.println("please input a text: ");
        Scanner scanner = new Scanner(System.in);
        //等待一个输入
        String str = scanner.next();
        System.out.printf("the input is: %s\n", str);
    }

}
