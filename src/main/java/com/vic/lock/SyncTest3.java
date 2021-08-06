package com.vic.lock;

public class SyncTest3 {

    static int i = 0;
    public static synchronized void test1() {
        i++;
    }

}
