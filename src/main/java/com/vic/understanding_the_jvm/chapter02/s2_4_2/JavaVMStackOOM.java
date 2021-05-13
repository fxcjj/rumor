package com.vic.understanding_the_jvm.chapter02.s2_4_2;

/**
 * -Xss2M(这时候不妨设置大些)
 *
 * 运行后系统会假死
 * ERROR: transport error 202: send failed: Software caused connection abort
 *
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }


    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }



    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
