package com.vic.concurrency.kuangshen.juc.v15;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " go out");
                latch.countDown(); // -1
            }, String.valueOf(i)).start();
        }

        latch.await(); //  等待归0，后面代码才能继续执行

        System.out.println("close door");
    }


}
