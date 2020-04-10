package com.vic.java8.functionalinterface;

/**
 * @author 罗利华
 * date: 2019/7/25 15:17
 */
@FunctionalInterface
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
    default void a() {
        // method body
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
     * 允许定义java.lang.Object里的public方法
     * 在接口中这样写，不被认为是抽象方法（虽然它们是抽象方法）
     * @param obj
     * @return
     */
    // override method of object class
    @Override
    boolean equals(Object obj);

}
