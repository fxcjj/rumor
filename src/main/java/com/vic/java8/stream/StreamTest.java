package com.vic.java8.stream;

import com.vic.entity.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 简洁又快速地处理集合——Java8 Stream
 * https://www.jianshu.com/p/0bb4daf6c800?from=groupmessage
 * https://www.jianshu.com/p/e429c517e9cb
 * http://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
 * @author 罗利华
 * date: 2020/3/14 17:02
 */
public class StreamTest {

    public static void main(String[] args) {
        List<User> lista = new ArrayList<>();

        lista.add(new User("u1", "p1"));
        lista.add(new User("u2", "p2"));
        lista.add(new User("u3", "p3"));
        lista.add(new User("u4", "p4"));
        lista.add(new User("u5", "p5"));
        lista.add(new User("u5", "p555"));


//        List<String> names = lista.stream().map(User::getUsername).collect(Collectors.toList());
//        names.forEach(System.out::println);

        // 当key重复时，会报错
//        Map<String, User> collect = lista.stream().collect(Collectors.toMap(User::getUsername, p -> p));
//        System.out.println(collect);

        // 当key重复时处理
        Map<String, User> adjunctVoMap = lista.stream().collect(Collectors.toMap(User::getUsername, v -> v, (k1, k2) -> k2));
        System.out.println(adjunctVoMap);
//		test1();

    }

    private static void test1() {
        // Count the empty strings
        List<String> strList = Arrays.asList("abc", "", "bde", "", "defg", "jk");
        long count = strList.stream().filter(x -> x.isEmpty()).count();
        System.out.printf("List %s has %d empty string %n", strList, count);

        // Count String with length more than 3
        long num = strList.stream().filter(x -> x.length() > 3).count();
        System.out.printf("List %s has %d strings of length more than 3 %n", strList, num);

        // Count number of string which startswith "a"
        count = strList.stream().filter(x -> x.startsWith("a")).count();
        System.out.printf("List %s has %d strings which startsWith 'a' %n", strList, count);

        // Remove all empty strings from list
        List<String> filtered = strList.stream().filter( x -> !x.isEmpty()).collect(Collectors.toList());
        System.out.printf("Original List: %s, List without empty strings: %s %n", strList, filtered);

        // Create a list with strings more than 2 characters
        filtered = strList.stream().filter( x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List: %s, filtered list: %s %n", strList, filtered);

        // Convert string to uppercase and join them using coma
        List<String> letters = Arrays.asList("a", "b", "c");
        String collect = letters.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(collect);

        //Create list of square of all distinct numbers
        List<Integer> numbers = Arrays.asList(1, 3, 5, 3, 5, 7, 8);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original list: %s, Square without duplicates: %s %n", numbers, distinct);

        // Get count, min, max, sum, and average for numbers
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("max: " + stats.getMax());
        System.out.println("min: " + stats.getMin());
        System.out.println("sum: " + stats.getSum());
        System.out.println("average: " + stats.getAverage());
    }


}
