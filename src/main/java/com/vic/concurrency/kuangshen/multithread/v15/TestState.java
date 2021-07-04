package com.vic.concurrency.kuangshen.multithread.v15;

/**
 * 线程的6种状态
 * New
 * Runnable(Running,Ready)
 * Waiting
 * Timed Waiting
 * Blocked
 * Terminated
 */
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("////////////");
        });

        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        // 启动后
        thread.start();
        state = thread.getState();
        System.out.println(state); //Running/Ready

        // 线种不终止，一直输出
        while(state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state); //当为终止时，退出循环
        }

        // 死亡之后不能两次启动
//        thread.start();

    }

}
