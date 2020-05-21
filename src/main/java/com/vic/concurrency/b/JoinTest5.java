package com.vic.concurrency.b;

/**
 * @author 罗利华
 * date: 2020/5/21 16:14
 */
public class JoinTest5 {

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread t1 = new Thread(joinThread);
        t1.start();

        System.out.println("main a");
        // 表示t1线程执行完毕后，才能继续往下执行main线程
        t1.join();
        System.out.println("main b");
    }


}

class JoinThread implements Runnable {

    @Override
    public void run() {
        try {
            // 模拟执行任务
            System.out.println("start task");
            Thread.sleep(2000);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
