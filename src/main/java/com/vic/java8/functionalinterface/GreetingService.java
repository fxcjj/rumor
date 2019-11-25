package com.vic.java8.functionalinterface;

/**
 * @author 罗利华
 * date: 2019/7/25 15:17
 */
//@FunctionalInterface
public interface GreetingService {

    void say(String message);

    // default method
    default void a() {
        // method body
    }

    // default method
    default void b() {
        // method body
    }

    // static method
    static void c() {
        System.out.println("c");
    }

    // override method of object class
    @Override
    boolean equals(Object obj);

}
