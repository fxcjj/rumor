package com.vic.lock;

public class SyncTest1 {

    int i = 0;
    public void test1() {
        synchronized (this) {
            i++;
        }
    }

}
