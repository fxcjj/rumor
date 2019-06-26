package com.vic.io;

import java.io.File;
import java.net.URI;

/**
 * 八
 * File测试
 * 
 * @author Victor
 */
public class FileTest {
    public static void main(String[] args) throws Exception {
        //testDir();
        //testFile();
        testURI();
        
    }

    //URI方式创建目录及文件
    private static void testURI() throws Exception {
        URI uri = new URI("file:/home/a/b/c");
        File dir = new File(uri);
        boolean mkdirs = dir.mkdirs();
        System.out.println(mkdirs);
        
        URI uri1 = new URI("file:/home/a/b/c/cc.txt");
        File file = new File(uri1);
        boolean createNewFile = file.createNewFile();
        System.out.println(createNewFile);
    }

    //创建文件
    private static void testFile() throws Exception {
        File file = new File("d:/coupling/pore/a.txt");
        file.createNewFile();
        
        String absolutePath = file.getAbsolutePath();
        String name = file.getName();
        String parent = file.getParent();
        String path = file.getPath();
        
        boolean isFile = file.isFile();
        System.out.println("isFile = " + isFile);
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("name = " + name);
        System.out.println("parent = " + parent);
        System.out.println("path = " + path);
    }

    //创建目录
    private static void testDir() {
        //创建子目录pore，若coupling父目录不存在，则fail
        File dir = new File("d:/coupling/pore");
        //dir.mkdir(); //此方法不行！
        dir.mkdirs(); //此方法可以！
        
        String absolutePath = dir.getAbsolutePath();
        String name = dir.getName();
        String parent = dir.getParent();
        String path = dir.getPath();
        
        boolean isDirectory = dir.isDirectory();
        
        System.out.println("isDirectory = " + isDirectory);
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("name = " + name);
        System.out.println("parent = " + parent);
        System.out.println("path = " + path);
        
        System.out.println();
    }
}
