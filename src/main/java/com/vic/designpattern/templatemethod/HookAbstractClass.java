package com.vic.designpattern.templatemethod;

/**
 * @author Victor
 * date: 2020/3/11 19:23
 */
public abstract class HookAbstractClass {

    /**
     * 模板方法
     */
    public void templateMethod() {
        abstractMethod1();
        hookMethod1();
        if(hookMethod2()) {
            specificMethod();
        }
        abstractMethod2();
    }

    /**
     * 钩子方法1
     */
    public void hookMethod1() {

    }

    /**
     * 钩子方法2
     */
    public boolean hookMethod2() {
        return true;
    }

    /**
     * 具体方法
     */
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    abstract void abstractMethod1(); // 抽象方法1
    abstract void abstractMethod2(); // 抽象方法2

}
