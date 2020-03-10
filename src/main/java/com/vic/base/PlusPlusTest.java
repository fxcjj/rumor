package com.vic.base;

/**
 * @author 罗利华
 * date: 2019/12/23 11:42
 */
public class PlusPlusTest {

    public static void main(String[] args) {

        int i = 1;
        System.out.println(i+++1); // 2

        // 变量在后，++i
//        test3();

        //变量在前，i++
//        test2();

        //
//        test1();
    }

    private static void test3() {
        int i = 1;
        int j2 = ++i; // 先将i变量的值加1，然后将i的当前值（2）赋值结变量j2（2）
        System.out.println("j2=" + j2); // 输出 j2=2
        System.out.println("i=" + i); // 输出 i=2
    }

    private static void test2() {
        int i = 1;
        // 先将i的原始值（1）赋值给变量j1（1），然后i变量的值加1
        int j1 = i++;
        System.out.println("j1=" + j1); // 输出 j1=1
        System.out.println("i=" + i); // 输出 i=2
    }

    private static void test1() {
        int i = 0;
        int j1 = i++; // 编译通过
        int j2 = ++i; // 编译通过

        i++; // 编译通过
        ++i; // 编译通过

//        i++ = 5; // 编译不通过
//        ++i = 5; // 编译不通过
    }
}
