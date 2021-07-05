package com.vic.designpattern.single;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉式
 */
public class LazyMan {

    private LazyMan() {
        System.out.println(Thread.currentThread().getName() + " ok");
    }

    private static LazyMan INSTANCE;

    public static LazyMan getInstance() {
        if (INSTANCE == null) {
            try {
                // 多线程下，这里可能放大问题
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new LazyMan();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazyMan.getInstance();
            }).start();
        }

    }
}
