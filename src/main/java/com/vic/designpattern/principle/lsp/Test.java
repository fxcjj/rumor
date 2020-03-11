package com.vic.designpattern.principle.lsp;

/**
 * 5 里氏替换原则（Liskov Substitution Principle）
 * http://c.biancheng.net/view/1324.html
 * @author 罗利华
 * date: 2020/3/11 14:43
 */
public class Test {
    public static void main(String[] args) {

        test2();

        test1();

    }

    /**
     * 修改 BrownKiWi 继承 Animal
     */
    private static void test2() {
        Bird bird1 = new Swallow();
        Animal animal = new BrownKiwi();

        bird1.setSpeed(120);
        animal.setRunSpeed(120);
        System.out.println("如果距离300公里：");

        try {
            System.out.println("燕子将飞行" + bird1.getFlyTime(300) + "小时.");
            System.out.println("几维鸟将奔跑" + animal.getRunTime(300) + "小时。");
        } catch(Exception err) {
            System.out.println("发生错误了!");
        }
    }

    /**
     * 当 BrownKiWi 继承 Bird 时
     */
    private static void test1() {
        /*Bird bird1 = new Swallow();
        Bird bird2 = new BrownKiwi();

        bird1.setSpeed(120);
        bird2.setSpeed(120);
        System.out.println("如果飞行300公里：");

        try {
            System.out.println("燕子将飞行" + bird1.getFlyTime(300) + "小时.");
            System.out.println("几维鸟将飞行" + bird2.getFlyTime(300) + "小时。");
        } catch(Exception err) {
            System.out.println("发生错误了!");
        }*/

        /*
        output:
        如果飞行300公里：
        燕子将飞行2.5小时.
        几维鸟将飞行Infinity小时。
         */

    }
}

