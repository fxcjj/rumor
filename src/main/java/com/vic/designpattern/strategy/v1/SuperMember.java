package com.vic.designpattern.strategy.v1;

/**
 * 超级会员
 * @author Victor
 * date: 2019/8/30 13:38
 */
public class SuperMember implements CalcPrice {

    @Override
    public double calc(double price) {
        return price * 0.8;
    }
}
