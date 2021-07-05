package com.vic.designpattern.single;

/**
 * 静态内部类
 */
public class StaticInnerClass {
    private StaticInnerClass() {}

    private static class Holder {
        private final static StaticInnerClass INS = new StaticInnerClass();
    }

    public StaticInnerClass getInstance() {
        return Holder.INS;
    }
}
