package com.vic.understanding_the_jvm.chapter04.s4_3_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 虚拟机参数：-Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class JConsoleTest {

    /**
     * 内存占位符对象，一个OOMObject大约占64KB
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }
}
