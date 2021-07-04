package com.vic.concurrency.kuangshen.juc.v16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("7颗龙珠集齐了");
        });

        for (int i = 0; i < 7; i++) {
            final int temp = i;
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"收集"+temp+"颗龙珠");
                    barrier.await(); // 相当于+1，当到达7时，执行Runnable
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
