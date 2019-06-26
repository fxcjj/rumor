package com.vic.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 一
 * 测试
 * 
 * @author Victor
 */
public class InputStreamReaderTest {
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        //BufferedInputStream
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("d:/a.txt")));
        byte[] buf = new byte[1024];
        int tmp = 0;
        while((tmp = bis.read(buf)) != -1) {
            sb.append(new String(buf, 0, tmp));
            //System.out.println(sb.toString());
        }
        System.out.println("文件的内容："+sb.toString());
        
        //InputStreamReader
        /*BufferedReader bufread;
        String read;
        bufread = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File("d:/a.txt")))));
        while ((read = bufread.readLine()) != null) {
            System.out.println(read);
        }
        bufread.close();*/
    }
    
}
