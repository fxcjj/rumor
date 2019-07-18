package com.vic.base;

/**
 * Class的isAssignableFrom方法
 * @author 罗利华
 * date: 2019/7/18 15:12
 */
public class IsAssignableFromTest {

    public static void main(String[] args) {
        Class<Thyme> thymeClass = Thyme.class;
        /**
         * 有两个Class类型的类象，一个是调用isAssignableFrom方法的类对象（称对象a），以及方法中作为参数的这个类对象（称对象b），这两个对象如果满足以下条件则返回true，否则返回false：
         *     a对象所对应类信息是b对象所对应的类信息的父类或者是父接口，简单理解即a是b的父类或接口
         *     a对象所对应类信息与b对象所对应的类信息相同，简单理解即a和b为同一个类或同一个接口
         *
         * 我的理解
         * A.class.isAssignableFrom(B.class);
         * 即判断参数B.class是否可以转换为A.class，能转换为true，否则为false
         */
        boolean a = thymeClass.isAssignableFrom(Epic.class);
        boolean b = thymeClass.isAssignableFrom(Thyme.class);
        boolean c = thymeClass.isAssignableFrom(Annunciate.class);
        System.out.println(a); // true
        System.out.println(b); // true
        System.out.println(c); // false
    }

}

interface Thyme {

}

class Epic implements Thyme{

}

class Annunciate {

}