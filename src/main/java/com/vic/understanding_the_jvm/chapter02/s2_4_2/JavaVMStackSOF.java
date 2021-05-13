package com.vic.understanding_the_jvm.chapter02.s2_4_2;

/**
 * -Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable r) {
            System.out.println("stack length: " + oom.stackLength);
            throw r;
        }
    }
}
