package com.vic.designpattern.single;

/**
 * 饿汉式
 */
public class Hungry {


    // 可能浪费空间
    private byte [] data1 = new byte[1024 * 1024];
    private byte [] data2 = new byte[1024 * 1024];
    private byte [] data3 = new byte[1024 * 1024];
    private byte [] data4 = new byte[1024 * 1024];

    private Hungry() {
    }

    private final static Hungry INSTANCE = new Hungry();

    public static Hungry getInstance() {
        return INSTANCE;
    }
}
