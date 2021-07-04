package com.vic.concurrency.kuangshen.multithread.v19;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            // 多个线程操作了相同位置
            new Thread(() -> {
                // 对list加锁，让线程串行执行
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();

        }
        Thread.sleep(3000);
//        Thread.currentThread().join();
        System.out.println(list.size());
    }
}
