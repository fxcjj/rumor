package com.vic.designpattern.templatemethod;

/**
 * 26 模板方法
 * http://c.biancheng.net/view/1376.html
 * @author Victor
 * date: 2020/3/11 19:28
 */
public class Test {

    public static void main(String[] args) {
        HookAbstractClass tm = new HookConcreteClass();
        tm.templateMethod();
    }

}
