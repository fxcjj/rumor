package com.vic.designpattern.principle7.dip;

/**
 * 6 依赖倒置原则
 * http://c.biancheng.net/view/1326.html
 * @author 罗利华
 * date: 2020/3/11 15:19
 */
public class Test {
    public static void main(String[] args) {
        Customer wang = new Customer();
        wang.shopping(new ShopA());
        wang.shopping(new ShopB());
    }
}
