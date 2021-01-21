package com.vic.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * IntStream使用
 * @author Victor
 * date: 2020/3/14 17:14
 */
public class IntStreamTest {

    public static void main(String[] args) {


        // 0 lambda循环一个list集合并获取循环的索引
        testGetIndexOfList();


        // 1 含头含尾
//        IntStream.rangeClosed(0, 5).forEach(System.out::println);

        // 2 含头不含尾
//        IntStream.range(0, 5).forEach(System.out::println);

        // 3 sum使用，0~5相加之和
        int sum = IntStream.rangeClosed(0, 5).sum();
//        System.out.println("sum:" + sum);

        int [] ints = {1, 3, 5, 8, 2, 45, 99};
//        IntStream.of(ints).sorted().forEach(System.out::println);

    }

    private static void testGetIndexOfList() {
        String[] names = { "Jon", "Darin", "Bauke", "Hans", "Marc" };
        List<String> list = Arrays.asList(names);

        // 方式1
        Stream.iterate(0, i -> i + 1).limit(list.size()).forEach(i -> {
            String s = list.get(i);
//            System.out.println("index: " + i + ", ele: " + s);
        });

        // 方式2
        IntStream.range(0, list.size())
                .mapToObj(i -> String.format("%d %s", i + 1, list.get(i)))
                .forEach(each -> {
                    System.out.println(each);
                });
    }

}
