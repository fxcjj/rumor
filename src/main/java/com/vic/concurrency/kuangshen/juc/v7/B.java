package com.vic.concurrency.kuangshen.juc.v7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class B {

    public static void main(String[] args) {

        Data2 data = new Data2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.dec();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.dec();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

// 判断等待、业务、通知
class Data2 {

    private int num;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    // +1
    public void inc() throws InterruptedException {
        lock.lock();
        try {
            while(num != 0) {
                // 等待
                condition.await();
            }
            // 业务
            num++;
            System.out.println(Thread.currentThread().getName()+"=>"+num);

            // 通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    // -1
    public void dec() throws InterruptedException {
        lock.lock();
        try {
            while(num == 0) {
                // 等待
                condition.await();
            }
            // 业务
            num--;
            System.out.println(Thread.currentThread().getName()+"=>"+num);

            // 通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}