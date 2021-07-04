package com.vic.concurrency.kuangshen.multithread.v22;

public class DeadLock {

    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                System.out.println("获得了a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 想获得b
            synchronized (b) {
                System.out.println("获得了b");
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println("获得了b");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            // 想获得a
            synchronized (a) {
                System.out.println("获得了a");
            }
        }).start();

    }


}
