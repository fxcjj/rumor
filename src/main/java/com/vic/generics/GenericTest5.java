package com.vic.generics;

import java.util.List;

/**
 * 泛型测试 —— ？ 和 T 的区别
 *
 * // 指定集合元素只能是T类型
 * List<T> list = new ArrayList<T>();
 *
 * // 集合元素可以是任意类型，这种没有意义，一般方法中，只是为了说明用法
 * List<?> list = new ArrayList<?>();
 *
 * ？和 T 都表示不确定的类型，区别在于我们可以对 T 进行操作，但是对 ？ 不行，比如如下这种 ：
 * // 可以
 * T t = operate();
 *
 * // 不可以
 * ？ car = operate();
 *
 * 简单总结下：
 * T 是一个 确定的 类型，通常用于泛型类和泛型方法的定义，？是一个 不确定 的类型，通常用于泛型方法的调用代码和形参，不能用于定义类和泛型方法。
 */
public class GenericTest5 {

    // 区别1：通过 T 来 确保 泛型参数的一致性
    // 通过 T 来 确保 泛型参数的一致性
    public <T extends Number> void test1(List<T> dest, List<T> src) {
        System.out.println(dest);
        System.out.println(src);
    }

    //通配符是 不确定的，所以这个方法不能保证两个 List 具有相同的元素类型
    public void test2(List<? extends Number> dest, List<? extends Number> src) {

    }

    // 区别2：类型参数可以多重限定而通配符不行
    /**
     * 使用 & 符号设定多重边界（Multi Bounds)，指定泛型类型 T 必须是 MultiLimitInterfaceA 和 MultiLimitInterfaceB 的共有子类型，
     * 此时变量 t 就具有了所有限定的方法和属性。对于通配符来说，因为它不是一个确定的类型，所以不能进行多重限定。
     *
     */
    class MultiLimit implements MultiLimitInterfaceA, MultiLimitInterfaceB {
        /**
         * 使用 & 符号设定多重边界（Multi Bounds)
         * @param t
         * @param <T>
         */
        public <T extends MultiLimitInterfaceA & MultiLimitInterfaceB> void test(T t) {

        }
    }

    interface MultiLimitInterfaceA {
    }
    interface MultiLimitInterfaceB {
    }


    // 区别3：通配符可以使用超类限定而类型参数不行
    /**
     * 类型参数 T 只具有 一种 类型限定方式：
     * T extends A
     *
     * 但是通配符 ? 可以进行 两种限定：
     * ? extends A
     * ? super A
     */


}
