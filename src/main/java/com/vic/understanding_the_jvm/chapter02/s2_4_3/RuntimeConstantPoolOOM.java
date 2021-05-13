package com.vic.understanding_the_jvm.chapter02.s2_4_3;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {



//        test2();

//        test1();
    }

    private static void test2() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    /**
     * jdk1.6应该可以
     */
    private static void test1() {
        // 使用list保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        // 10MB 的 PermSize 在 integer 范围内足够产生OOM 了
        int i = 0;
        while(true) {
            // jdk1.8这里会一直执行下去
            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }

    }

}
