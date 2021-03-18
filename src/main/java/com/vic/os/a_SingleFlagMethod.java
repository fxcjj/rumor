package com.vic.os;

import org.apache.poi.ss.formula.functions.T;

/**
 * https://www.zhihu.com/collection/568802519
 * 单标志法
 * @author Victor
 * date: 2021/3/18 10:14
 */
public class a_SingleFlagMethod {

    public static int turn = 0;

    public static void main(String[] args) throws Exception {

        // 单标志法
        // 不能做到空闲让进，改进
        P1 p1 = new P1();
        P2 p2 = new P2();
        new Thread(p1).start();
        new Thread(p2).start();
    }

}

class P1 implements Runnable {

    @Override
    public void run() {
        while(true) {
            /*进程p1*/
            while (a_SingleFlagMethod.turn != 0) {
                // do nothing
//            System.out.println("p1 do nothing");
            }
            /**p1的临界区**/
            System.out.println("开始执行p1临界区");
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束执行p1临界区");
            System.out.println();
            a_SingleFlagMethod.turn = 1;
            /**剩余区**/
        }
    }
}

class P2 implements Runnable {

    @Override
    public void run() {
        while(true) {
            /*进程p2*/
            while (a_SingleFlagMethod.turn != 1) {
                // do nothing
//            System.out.println("p2 do nothing");
            }
            /**p2的临界区**/
            System.out.println("开始执行p2临界区");
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束执行p2临界区");
            System.out.println();
            a_SingleFlagMethod.turn = 0;
            /**剩余区**/
        }
    }
}
