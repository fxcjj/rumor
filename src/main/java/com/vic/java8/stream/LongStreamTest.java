package com.vic.java8.stream;

import java.util.stream.LongStream;

/**
 * LongStream使用
 * @author Victor
 * date: 2020/3/14 17:14
 */
public class LongStreamTest {

    public static void main(String[] args) {
        // 1 含头含尾
//        LongStream.rangeClosed(0, 5).forEach(System.out::print);

        // 2 含头不含尾
//        LongStream.range(0, 5).forEach(System.out::print);

        // 3 sum使用，0~3相加之和
        long sum = LongStream.rangeClosed(0, 3).sum();
//        System.out.println("sum:" + sum);

        long [] nums = {1, 99, 3, 5, 8, 2, 45};
        LongStream.of(nums).sorted().forEach(System.out::println);

    }

}
