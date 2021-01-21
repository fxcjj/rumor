package com.vic.designpattern.templatemethod.a;

/**
 * @author Victor
 * date: 2020/3/11 19:14
 */
public class Test {
    public static void main(String[] args) {
        AbstractLove love = new ManLove();
        love.makeLove();
    }
}
