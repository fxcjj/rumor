package com.vic.java8.defaultmethod;

/**
 * 1. 实现类可以直接使用父接口中定义的default方法
 * 2. 接口可以重写父接口中定义的default方法
 * 3. 实现类可以重写父接口中定义的方法
 * 4. 当父类和父接口都存在default方法时，优先使用父类中重写的default方法
 * Specially, 如果一个类实现了两个接口，这两个接口中有同名的default方法签名时，此时编译不通过，必须在子类中重写这个default方法。
 *
 * @author Victor
 * date: 2019/7/25 14:46
 */
public class Main {

    public static void main(String[] args) {

        // 测试实现类可以直接调用父接口中的default方法
        Parent pa = new ParentImpla();
        // 输出Parent
        pa.fuck();

        // 测试ParentImplb重写了Parent接口中default方法
        Parent pb = new ParentImplb();
        // 输出ParentImplb
        pb.fuck();

        // 测试Child接口重写了Parent接口的default方法
        Child ca = new ChildImpla();
        // 输出Child
        ca.fuck();

        // 测试ChildImplb父类和实现的接口都有default方法，优先使用父类中定义的方法
        Child cb = new ChildImplb();
        // 输出ParentImplb
        cb.fuck();
    }

}
