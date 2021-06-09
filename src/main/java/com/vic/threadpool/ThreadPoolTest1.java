package com.vic.threadpool;

import java.util.concurrent.*;

/**
 * 测试线程池默认的拒绝策略
 */
public class ThreadPoolTest1 {

    public static void main(String[] args) {
        // 设置了最大线程队列是100
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);

        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");

        // 创建线程池，没有设置拒绝策略，使用默认的拒绝策略（即 AbortPolicy 丢弃任务并抛出RejectedExecutionException异常）
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, queue, factory);

        while(true) {
            executor.submit(() -> {
                try {
                    // 任务：打印queue大小，睡眠10秒
                    System.out.println(queue.size());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
