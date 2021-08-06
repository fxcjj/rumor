package com.vic.designpattern.principle.solid.dip;

/**
 * 依赖倒置原则
 * http://c.biancheng.net/view/1326.html
 * @author Victor
 * date: 2020/3/11 15:19
 */
public class Test {
    public static void main(String[] args) {
        Customer wang = new Customer();
        wang.shopping(new ShopA());
        wang.shopping(new ShopB());
    }
}
