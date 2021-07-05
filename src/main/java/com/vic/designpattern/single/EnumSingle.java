package com.vic.designpattern.single;

import java.lang.reflect.Constructor;

/**
 * 枚举单例
 */
public enum EnumSingle {

    INS;

    public static EnumSingle getIns() {
        return INS;
    }
}


class Test {
    public static void main(String[] args) throws Exception {
        EnumSingle ins1 = EnumSingle.getIns();

        // 枚举的构造方法有两个参数，String s, int i
        Constructor<EnumSingle> declaredConstructor
                = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);

        EnumSingle ins2 = declaredConstructor.newInstance();
        System.out.println(ins1);
        System.out.println(ins2);

        /*
        IllegalArgumentException: Cannot reflectively create enum objects
         */
    }

    public void test1() {
        EnumSingle ins1 = EnumSingle.getIns();
        EnumSingle ins2 = EnumSingle.getIns();
        System.out.println(ins1);
        System.out.println(ins2);
    }
}