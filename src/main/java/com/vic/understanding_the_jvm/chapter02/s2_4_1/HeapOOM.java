package com.vic.understanding_the_jvm.chapter02.s2_4_1;

import java.util.ArrayList;
import java.util.List;

/**
 * heap out of memory
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author Victor
 * date: 2020/3/26 19:39
 */
public class HeapOOM {

    static class OOMObject {
        byte [] a = new byte[1024*1024]; //1m
    }
    static int count = 0;

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new OOMObject());
                count++;
            }
        } catch (OutOfMemoryError e) {
            System.out.println("count: " + count);
            e.printStackTrace();
        }
    }

}
