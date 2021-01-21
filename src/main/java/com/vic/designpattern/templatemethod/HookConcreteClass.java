package com.vic.designpattern.templatemethod;

/**
 * @author Victor
 * date: 2020/3/11 19:27
 */
public class HookConcreteClass extends HookAbstractClass {
    @Override
    void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }

    @Override
    public void hookMethod1() {
        System.out.println("钩子方法1被重写...");
    }

    @Override
    public boolean hookMethod2() {
        return true;
    }
}
