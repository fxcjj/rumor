package com.vic.concurrency.kuangshen.juc.v17;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args) {
        // 一次可拿到的许可，即可运行多少线程
        // 举例：3个停车位
        Semaphore semaphore = new Semaphore(3);

        // 6辆车进来，前123停车，停了3秒后离开，456才可以进来
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    // 获取一个许可
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放一个许可
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }

    }

}

/*
output:
0抢到车位
2抢到车位
3抢到车位
0离开车位
1抢到车位
2离开车位
4抢到车位
3离开车位
5抢到车位
1离开车位
4离开车位
5离开车位
 */