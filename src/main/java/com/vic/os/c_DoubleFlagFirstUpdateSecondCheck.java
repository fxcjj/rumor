package com.vic.os;

/**
 * 双标志，先修改后检查
 * @author Victor
 * date: 2021/3/18 11:22
 */
public class c_DoubleFlagFirstUpdateSecondCheck {

    static boolean[] flag = {false, false};

    public static void main(String[] args) {
        /**
         * 双标志，先修改后检查
         * 一种极端的情况：
         * 假设P1和P2都同时想进入临界区，并发执行的顺序同方法二，那么都将自己置为true，此时while循环执行，发现对方也想进入，于是相互谦让，导致谁都访问不了这个资源，产生饥饿现象。
         */
        new Thread(new P5()).start();
        new Thread(new P6()).start();
    }

}

class P5 implements Runnable {

    @Override
    public void run() {
        while(true) {
            c_DoubleFlagFirstUpdateSecondCheck.flag[0] = true;
            while (c_DoubleFlagFirstUpdateSecondCheck.flag[1]) { // (1)
                // do nothing
            }
            c_DoubleFlagFirstUpdateSecondCheck.flag[0] = true; // (3)
            /* p1的临界区 */
            System.out.println("开始执行p1临界区");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束执行p1临界区");
            System.out.println();
            c_DoubleFlagFirstUpdateSecondCheck.flag[0] = false;
            /* 剩余区 */
        }
    }
}

class P6 implements Runnable {

    @Override
    public void run() {
        while (true) {
            c_DoubleFlagFirstUpdateSecondCheck.flag[1] = true;
            while (c_DoubleFlagFirstUpdateSecondCheck.flag[0]) { // (2)
                // do nothing
            }
            c_DoubleFlagFirstUpdateSecondCheck.flag[1] = true; // (4)
            /* p2的临界区 */
            System.out.println("开始执行p2临界区");
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束执行p2临界区");
            System.out.println();
            c_DoubleFlagFirstUpdateSecondCheck.flag[1] = false;
            /* 剩余区 */
        }
    }

}
