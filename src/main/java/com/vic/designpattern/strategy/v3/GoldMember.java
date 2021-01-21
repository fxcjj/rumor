package com.vic.designpattern.strategy.v3;

import com.vic.designpattern.strategy.v1.CalcPrice;

/**
 * 金牌会员
 * @author Victor
 * date: 2019/8/30 13:38
 */
@PriceRange(min = 3000)
public class GoldMember implements CalcPrice {

    @Override
    public double calc(double price) {
        return price * 0.7;
    }
}
