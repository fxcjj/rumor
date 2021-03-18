package com.vic.os;

/**
 * 双标志先检查法
 * https://www.zhihu.com/collection/568802519
 * @author Victor
 * date: 2021/1/22 10:22
 */
public class b_DoubleFlagEarlierMethod {

    static boolean[] flag = {false, false};

    public static void main(String[] args) {
        /**
         * 双标志先检查法
         * 这样就违背了“忙则等待”。即有进程在访问临界资源的时候，其他进程必须等待。
         */
        P3 p3 = new P3();
        P4 p4 = new P4();
        new Thread(p3).start();
        new Thread(p4).start();
    }

}

class P3 implements Runnable {

    @Override
    public void run() {
        while(true) {
            while (b_DoubleFlagEarlierMethod.flag[1]) { // (1)
                // do nothing
            }
            b_DoubleFlagEarlierMethod.flag[0] = true; // (3)
            /* p1的临界区 */
            System.out.println("开始执行p1临界区");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束执行p1临界区");
            System.out.println();
            b_DoubleFlagEarlierMethod.flag[0] = false;
            /* 剩余区 */
        }
    }
}

class P4 implements Runnable {

    @Override
    public void run() {
        while(true) {
            while (b_DoubleFlagEarlierMethod.flag[0]) { // (2)
                // do nothing
            }
            b_DoubleFlagEarlierMethod.flag[1] = true; // (4)
            /* p2的临界区 */
            System.out.println("开始执行p2临界区");
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束执行p2临界区");
            System.out.println();
            b_DoubleFlagEarlierMethod.flag[1] = false;
            /* 剩余区 */
        }

    }
}