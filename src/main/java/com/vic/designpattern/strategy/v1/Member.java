package com.vic.designpattern.strategy.v1;

/**
 * 会员
 * @author 罗利华
 * date: 2019/8/30 13:38
 */
public class Member implements CalcPrice {

    @Override
    public double calc(double price) {
        return price;
    }
}
