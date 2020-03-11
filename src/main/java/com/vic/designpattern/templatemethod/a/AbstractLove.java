package com.vic.designpattern.templatemethod.a;

/**
 *
 * @author 罗利华
 * date: 2020/3/11 19:04
 */
public abstract class AbstractLove {

    /**
     * 模板方法
     */
    public void makeLove() {
        takeOff();
        love();
    }

    /**
     * 具体方法，子类可以继承或重写它
     */
    public void takeOff() {
        System.out.println("take off");
    }

    /**
     * 抽象方法，子类必须实现
     */
    abstract void love();

    /**
     * 钩子方法，包括两种：
     * 1）用于判断的逻辑方法
     * 2）需要子类重写的空方法
     */
    //略
}
