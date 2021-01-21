package com.vic.java8.defaultmethod;

/**
 * @author Victor
 * date: 2019/7/25 14:30
 */
public interface Child extends Parent {

    /**
     * 重写父接口中的default方法
     */
    @Override
    default void fuck() {
        System.out.println("Child");
    }
}
