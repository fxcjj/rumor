package com.vic.retry;

/**
 * 重试机制
 * @author Victor
 * date: 2019/4/15 16:03
 */
public class RetryTest {


    public static void main(String[] args) {
        //重试方式1
//        test1();

        test2();

    }

    /**
     * 2. do-while
     */
    public static void test2() {

        int maxRetryTime = 3;
        int time = 0;
        String result = null;
        do {
            time++;
            System.out.println("第" + time + "次执行");
            try {
                result = pear();
            } catch (Exception e) {
                try {
                    //暂停2秒
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        } while (result == null && time < maxRetryTime);

    }

    public static String pear() {
        System.out.println("Execute pear method");
        String r = getResult();
        if(r == null)
            throw new RuntimeException("pear method occurs error");
        return "pear";
    }

    private static String getResult() {
        return null;
    }


    /**
     * 1. try-catch
     */
    public static void test1() {
        try {
            nonce();
        } catch (Exception e) {
            try {
                //3秒后重试，只重试一次
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            nonce();

        }

    }

    public static void nonce() {
        System.out.println("Execute nonce method.");
        throw new RuntimeException("nonce method occurs error");
    }

}
