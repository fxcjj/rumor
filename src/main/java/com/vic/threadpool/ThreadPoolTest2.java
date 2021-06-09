package com.vic.threadpool;

import java.util.concurrent.*;

/**
 * 测试线程池指定的拒绝策略
 */
/*
output:
test-thread-pool: 执行任务
test-thread-pool: 执行任务
main: 执行任务
test-thread-pool: 执行任务
test-thread-pool: 执行任务
test-thread-pool: 执行任务
main: 执行任务
test-thread-pool: 执行任务
test-thread-pool: 执行任务
test-thread-pool: 执行任务
test-thread-pool: 执行任务


 */
public class ThreadPoolTest2 {

    public static void main(String[] args) {
        // 设置了最大线程队列是10
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);

        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");

        // 创建线程池，设置拒绝策略（即 CallerRunsPolicy 由调用线程处理该任务）
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 1000; i++) {
            // 提交任务
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ": 执行任务");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
