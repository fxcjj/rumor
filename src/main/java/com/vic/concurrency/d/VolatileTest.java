package com.vic.concurrency.d;

import java.util.concurrent.CountDownLatch;

/**
 * volatile自增运算测试
 * @author 罗利华
 * date: 2020/5/25 17:21
 */
public class VolatileTest {

    public static volatile int race = 0;

    /**
     * // 多个线程到这里是正确的，但是由于后面指令执行加1操作时，发生线程切换，那么其它线程读取到的值是过期的
     * 0 getstatic #2 <com/vic/concurrency/d/VolatileTest.race>
     * 3 iconst_1
     * 4 iadd
     * 5 putstatic #2 <com/vic/concurrency/d/VolatileTest.race>
     * 8 return
     */
    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                    // 让latch中的数值减1
                    latch.countDown();
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        /*while(Thread.activeCount() > 1) {
            Thread.yield();
        }*/

        /*for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].join();
        }*/

        // 阻塞当前线程直到latch中的值为0
        latch.await();
        /**
         * 多次执行打印
         * 167647
         * 163975
         * 135499
         */
        System.out.println(race);

    }


}
