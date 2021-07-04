package com.vic.concurrency.kuangshen.multithread.v7;

import org.apache.commons.lang3.RandomUtils;

public class Race implements Runnable {

    private String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            if("兔子".equals(Thread.currentThread().getName())) {
                try {
                    Thread.sleep(RandomUtils.nextInt(1, 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "--->跑了"+i+"步");

            boolean flag = gameOver(i);
            if(flag) {
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } {
            if(steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println(winner+"赢了比赛");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }


}
