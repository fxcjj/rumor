package com.vic.concurrency.kuangshen.juc.v7;



public class A {

    public static void main(String[] args) {

        Data data = new Data();

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
class Data {

    private int num;

    // +1
    public synchronized void inc() throws InterruptedException {
        while(num != 0) {
//        if(num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }

    // -1
    public synchronized void dec() throws InterruptedException {
        while(num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }

}


