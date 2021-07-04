package com.vic.concurrency.kuangshen.juc.v7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程顺序打印
 * A执行完调用B，B执行完调用C，C执行完调用A
 */
public class C {

    public static void main(String[] args) {

        Data3 data = new Data3();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }, "C").start();



    }
}

class Data3 {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private int num = 1; // 1A 2B 3C

    public void printA() {
        lock.lock();
        try {
            // 判断等待
            while(num != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>AAA");
            // 业务
            num = 2;

            // 精确唤醒
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            // 判断等待
            while(num != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>BBB");
            // 业务
            num = 3;

            // 精确唤醒
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            // 判断等待
            while(num != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>CCC");
            // 业务
            num = 1;

            // 精确唤醒
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
