package com.vic.designpattern.single;

import java.lang.reflect.Constructor;

/**
 * DCL懒汉式
 */
public class LazyMan2 {

    private LazyMan2() {
        synchronized (LazyMan2.class) {
            if(INSTANCE != null) {
                throw new RuntimeException("不要试图使用反射");
            }
        }
//        System.out.println(Thread.currentThread().getName() + " ok");
    }

    private volatile static LazyMan2 INSTANCE;

    public static LazyMan2 getInstance() {
        if (INSTANCE == null) {
           synchronized (LazyMan2.class) {
               if(INSTANCE == null) {
                   INSTANCE = new LazyMan2(); // 不是一个原子操作
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
//        LazyMan2 instance = LazyMan2.getInstance();

        Constructor<LazyMan2> constructor = LazyMan2.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LazyMan2 instance = constructor.newInstance();
        LazyMan2 instance2 = constructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);

        /*
        com.vic.designpattern.single.LazyMan2@816f27d
        com.vic.designpattern.single.LazyMan2@87aac27
         */
    }

    /**
     * 正常
     * LazyMan2.getInstance() 与 反射实例比较
     * @throws Exception
     */
    private static void test1() throws Exception {
        LazyMan2 instance = LazyMan2.getInstance();

        Constructor<LazyMan2> constructor = LazyMan2.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LazyMan2 instance2 = constructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }


}
