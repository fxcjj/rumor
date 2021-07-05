package com.vic.designpattern.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * DCL懒汉式
 */
public class LazyMan3 {

    private static boolean xxyy = false;

    private LazyMan3() {
        synchronized (LazyMan3.class) {
            if(!xxyy) {
                xxyy = true;
            } else {
                throw new RuntimeException("不要试图使用反射");
            }
        }
//        System.out.println(Thread.currentThread().getName() + " ok");
    }

    private volatile static LazyMan3 INSTANCE;

    public static LazyMan3 getInstance() {
        if (INSTANCE == null) {
           synchronized (LazyMan3.class) {
               if(INSTANCE == null) {
                   INSTANCE = new LazyMan3(); // 不是一个原子操作
                   /**
                    * 1. 分配内存空间
                    * 2. 执行构造方法，初始化对象
                    * 3. 把这个对象指向这个空间
                    *
                    * 期望顺序：123
                    * 由于指令重排可能会：132，那么其它线程在入口处判断INSTANCE是否为空不成立，那么就返回。
                    * 此时还没有完成构造方法，就有问题了
                    */
               }
           }

        }
        return INSTANCE;
    }

    // 反射
    public static void main(String[] args) throws Exception {

//        test1();

        test2();
    }

    /**
     * 破坏
     * @throws Exception
     */
    private static void test2() throws Exception {
        Field xxyy = LazyMan3.class.getDeclaredField("xxyy");
        xxyy.setAccessible(true);

        Constructor<LazyMan3> constructor = LazyMan3.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LazyMan3 instance = constructor.newInstance();

        xxyy.set(instance, false);

        LazyMan3 instance2 = constructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);

        /*
        com.vic.designpattern.single.LazyMan3@87aac27
        com.vic.designpattern.single.LazyMan3@3e3abc88
         */

    }

    /**
     * 正常
     * @throws Exception
     */
    private static void test1() throws Exception {
        Constructor<LazyMan3> constructor = LazyMan3.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LazyMan3 instance = constructor.newInstance();
        LazyMan3 instance2 = constructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);

    }


}
