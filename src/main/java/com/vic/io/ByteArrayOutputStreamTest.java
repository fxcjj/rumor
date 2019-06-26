package com.vic.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二
 * 字节数组输出流测试
 * 
 * @author Victor
 */
public class ByteArrayOutputStreamTest {
    // 对应英文字母“abcddefghijklmnopqrsttuvwxyz”  
    private static final byte[] ArrayLetters = { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68,
            0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76,
            0x77, 0x78, 0x79, 0x7A          };

    public static void main(String[] args) throws IOException {
        //创建字节数组输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //写入三个字母，即0x41对应A，0x42对应B，0x43对应C
        baos.write(0x41);
        baos.write(0x42);
        baos.write(0x43);

        //toString方法是new String(buf, 0, count);
        System.out.println("baos: " + baos);

        //将ArrayLetters从3开始后5个字节写入到baos中
        //即0x64, 0x65, 0x66, 0x67, 0x68，defgh
        baos.write(ArrayLetters, 3, 5);
        System.out.println("baos: " + baos); //ABCdefgh

        //长度
        System.out.println("baos length: " + baos.size()); //8

        byte[] byteArray = baos.toByteArray();

        System.out.println(new String(byteArray)); //ABCdefgh

        //将baos写入到另一个ByteArrayOutputStream中
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        baos.writeTo((OutputStream) baos1);
        System.out.println("baos1: " + baos1); //ABCdefgh

    }

}
