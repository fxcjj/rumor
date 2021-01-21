package com.vic.designpattern.strategy.v3;

import com.vic.designpattern.strategy.v1.CalcPrice;

/**
 * 会员
 * @author Victor
 * date: 2019/8/30 13:38
 */
@PriceRange(max = 1000)
public class Member implements CalcPrice {

    @Override
    public double calc(double price) {
        return price;
    }
}
