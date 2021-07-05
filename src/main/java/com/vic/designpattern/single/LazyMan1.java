package com.vic.designpattern.single;

import java.lang.reflect.Constructor;

/**
 * DCL懒汉式
 */
public class LazyMan1 {

    private LazyMan1() {
        System.out.println(Thread.currentThread().getName() + " ok");
    }

    private volatile static LazyMan1 INSTANCE;

    public static LazyMan1 getInstance() {
        if (INSTANCE == null) {
           synchronized (LazyMan1.class) {
               if(INSTANCE == null) {
                   INSTANCE = new LazyMan1(); // 不是一个原子操作
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

    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LazyMan1.getInstance();
//            }).start();
//        }

        test2();

    }

    /**
     * 破坏
     */
    private static void test2() throws Exception {
        LazyMan1 instance = LazyMan1.getInstance();

        Constructor<LazyMan1> constructor = LazyMan1.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LazyMan1 instance2 = constructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
