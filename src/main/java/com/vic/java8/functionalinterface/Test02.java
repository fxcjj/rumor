package com.vic.java8.functionalinterface;

/**
 * 函数式接口测试
 * https://www.cnblogs.com/runningTurtle/p/7092632.html
 * https://www.jianshu.com/p/52cdc402fb5d
 *
 * 1. @FunctionInterface主要用于编译级错误检查，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错
 * 2. 加不加@FunctionalInterface对于接口是不是函数式接口没有影响，该注解只是提醒编译器去检查该接口是否仅包含一个抽象方法
 *
 * @author 罗利华
 * date: 2019/7/25 15:19
 */
public class Test02 {

    public static void main(String[] args) {

        // 使用lambda表达式来表示该接口的一个实现（java8之前一般使用匿名类实现的）
        GreetingService gs = new GreetingServiceImpl();
        // hello, justin
        gs.say("justin");

        System.out.println(gs.a());

    }

}
