package com.vic.java8.functionalinterface;

/**
 *
 * 1. 满足 functional interface 的条件
 *  a) 仅含有一个抽象方法（默认修饰符public abstract）
 *  b) 允许定义默认方法和覆盖 java.lang.Object 类的方法
 *  c) 当满足条件时，不论是否在接口上声明 @FunctionalInterface 注解，它都是 functional interface
 *
 * @author 罗利华
 * date: 2019/7/25 15:17
 */
//@FunctionalInterface
public interface GreetingService {

    /**
     * 第一个抽象方法
     * @param message
     */
    public abstract void say(String message);

    /**
     * 第二个抽象方法
     * 当接口上加 @FunctionalInterface 时，与该方法冲突
     */
//    public abstract void say1(String message);

    /**
     * 接口中允许定义默认方法，它不是抽象方法
     */
    // default method
    default String a() {
        // method body
        return null;
    }

    // default method
    default void b() {
        // method body
    }

    /**
     * 允许定义静态方法，有自己实现，它不是一个抽象方法
     */
    // static method
    static void c() {
        System.out.println("c");
    }

    /**
     * 在功能接口中，允许覆盖 java.lang.Object 里的public方法，它不被认为是抽象方法（虽然它们是抽象方法）
     * @param obj
     * @return
     */
    // override method of object class
    @Override
    public abstract boolean equals(Object obj);

}
