package com.vic.generics;

/**
 * 泛型测试1 —— 泛型带来的好处
 *
 * https://juejin.im/post/5d5789d26fb9a06ad0056bd9
 * @author Victor
 * date: 2021/1/21 10:39
 */
public class GenericTest1<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    /**
     * 不指定类型
     */
    public void noSpecifyType() {
        GenericTest1 s = new GenericTest1();
        s.setT("test1");
        // 需要强制类型转换
        String test = (String)s.getT();
        System.out.println(test);
    }

    /**
     * 指定类型
     */
    public void specifyType() {
        GenericTest1<String> s = new GenericTest1<>();
        s.setT("test");
        // 不需要强制类型转换
        String test = s.getT();
        System.out.println(test);
    }


}
