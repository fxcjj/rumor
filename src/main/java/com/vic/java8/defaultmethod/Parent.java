package com.vic.java8.defaultmethod;


/**
 * @author Victor
 * date: 2019/7/25 14:43
 */
public interface Parent {

    default void fuck() {
        System.out.println("Parent");
    }

}
