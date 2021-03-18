package com.vic.os;

/**
 * Peterson's算法
 * https://www.zhihu.com/collection/568802519
 * @author Victor
 * date: 2021/3/18 11:18
 */
public class d_Peterson {
    static boolean[] flag = {false, false};
    static int turn = 0;

    public static void main(String[] args) {

        /**
         * 所以这个方法实现了“空闲让进”和"忙则等待"
         */
        new Thread(new P7()).start();
        new Thread(new P8()).start();
    }

}


class P7 implements Runnable {

    @Override
    public void run() {
        while (true) {
            d_Peterson.flag[0] = true;
            d_Peterson.turn = 1;
            while (d_Peterson.flag[1] && d_Peterson.turn == 1) {
                // do nothing
            }
            /* p1的临界区 */
            System.out.println("开始执行p1临界区");
            System.out.println("结束执行p1临界区");
            System.out.println();
            d_Peterson.flag[0] = false;
            /* 剩余区 */
        }
    }
}

class P8 implements Runnable {

    @Override
    public void run() {
        while (true) {
            d_Peterson.flag[1] = true;
            d_Peterson.turn = 0;
            while (d_Peterson.flag[0] && d_Peterson.turn == 0) {
                // do nothing
            }
            /* p2的临界区 */
            System.out.println("开始执行p2临界区");
            System.out.println("结束执行p2临界区");
            System.out.println();
            d_Peterson.flag[1] = false;
            /* 剩余区 */
        }
    }

}