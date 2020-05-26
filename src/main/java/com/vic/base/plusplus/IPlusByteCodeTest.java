package com.vic.base.plusplus;

/**
 * The difference between i++ and ++i
 * @author victor
 * date: 2019/12/23 11:53
 * https://blog.csdn.net/xialei199023/article/details/76383013
 */
public class IPlusByteCodeTest {

    public static void main(String[] args) {

        int i = 0;
        System.out.println(i+++1);
//        testPlusI();

//        testIPlus();
    }

    /**
     * // int型常量0入栈
     * 0 iconst_0
     * // 将栈顶元素放入索引为0的本地变量
     * 1 istore_0
     * // 从当前帧中索引为0的本地变量数组中加载int常量0，并推入操作数栈中
     * 2 iload_0
     * // 索引为0的本地变量加1
     * 3 iinc 0 by 1
     * // 将栈顶元素出栈，并放入到索引为1的本地变量中
     * 6 istore_1
     * 7 return
     */
    public static void testIPlus() {
        int i = 0;
        int j = i++;
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);

    }

    /**
     * 0 iconst_0
     * 1 istore_0
     * 2 iinc 0 by 1
     * 5 iload_0
     * 6 istore_1
     * 7 return
     */
    public static void testPlusI() {
        int i = 0;
        int j = ++i;
//        System.out.println("i = " + i);
//        System.out.println("j = " + j);
    }
}
