package com.vic.java8.functionalinterface;

/**
 * 函数式接口测试
 * https://www.cnblogs.com/runningTurtle/p/7092632.html
 * https://www.jianshu.com/p/52cdc402fb5d
 * @author 罗利华
 * date: 2019/7/25 15:19
 */
public class Test01 {

    public static void main(String[] args) {

        GreetingService gs = message -> System.out.println("hello, " + message);
        // hello, justin
        gs.say("justin");

        // 静态方法
        GreetingService.c();

        // 简洁
        Runnable r = () -> System.out.println("hello");
        new Thread(r).start();

    }

}
