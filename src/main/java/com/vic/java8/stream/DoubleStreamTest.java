package com.vic.java8.stream;

import java.util.stream.DoubleStream;

/**
 * DoubleStream使用
 * @author 罗利华
 * date: 2020/3/14 17:14
 */
public class DoubleStreamTest {

    public static void main(String[] args) {
        double[] nums = {2.4d, 2.5d, 3.8d, 1.2d};
        // 每个元素+2
        DoubleStream.of(nums)
                .map(ele -> ele + 2)
                .forEach(ele -> {
//                    System.out.println(ele);
                });

        // 计算平均值
        double asDouble = DoubleStream.of(nums).average().getAsDouble();
//        System.out.println(asDouble);

        // 查找最大值
        double maxNum = DoubleStream.of(nums).max().getAsDouble();
//        System.out.println(maxNum);

        // 查找 x>=3 且 x<=4的值
        DoubleStream.of(2.0, 3.0, 4.0, 5.0)
                .filter(ele -> ele >= 3.0 && ele <= 4.0)
                .forEach(System.out::println);
    }

}
