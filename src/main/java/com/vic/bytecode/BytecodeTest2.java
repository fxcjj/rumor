package com.vic.bytecode;

/**
 * 字节码测试
 * https://www.oschina.net/translate/introduction-to-java-bytecode?lang=chs&p=1
 * @author victor
 * @date: 2020/5/21 10:23
 */
public class BytecodeTest2 {

    /**
     * main方法字节码：
     *  // 将int类型常量1放入操作数栈
     *  0 iconst_1
     *  // 将操作数栈中第一个int类型值出栈，并放入索引为1的本地变量中
     *  1 istore_1
     *  // 将int类型常量2放入操作数栈
     *  2 iconst_2
     *  // 将操作数栈中第一个int类型值出栈，并放入索引为2的本地变量中
     *  3 istore_2
     *  // 从索引为1的本地变量中加载一个int类型值放入操作数栈
     *  4 iload_1
     *  // 从索引为2的本地变量中加载一个int类型值放入操作数栈
     *  5 iload_2
     *  // 调用静态方法calc
     *  6 invokestatic #3 <com/vic/concurrency/a/Test.calc>
     *  // 将操作数栈中第一个int值出栈（即calc方法计算得到的结果），放入到索引为3的本地变量中
     *  9 istore_3
     *  // 从这个void方法中返回
     *  10 return
     * @param args
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = calc(a, b);

        // iadd指令 把操作数栈中的前两个int值出栈并相加，将相加的结果放入操作数栈。
//        int c = a + b;
    }

    /**
     *  // 从索引为0的本地变量中加载一个int值，放入操作数栈中
     *  0 iload_0
     *  // int转换为double类型
     *  1 i2d
     *  // 将double型常量值2.0d从常量池中推送至栈顶（宽索引）
     *  2 ldc2_w #3 <2.0>
     *  // 调用静态方法
     *  5 invokestatic #5 <java/lang/Math.pow>
     *  // 从索引为1的本地变量中加载一个int值，放入操作数栈中
     *  8 iload_1
     *  // int转换为double类型
     *  9 i2d
     * 10 ldc2_w #3 <2.0>
     * 13 invokestatic #5 <java/lang/Math.pow>
     * // 将栈顶的两个中间结果出栈，将它们相加，并将所得之和推入栈顶
     * 16 dadd
     * 17 invokestatic #6 <java/lang/Math.sqrt>
     * 20 d2i
     * 21 ireturn
     *
     * @param a
     * @param b
     * @return
     */
    private static int calc(int a, int b) {
        return (int)Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }



}
