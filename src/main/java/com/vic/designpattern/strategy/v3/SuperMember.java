package com.vic.designpattern.strategy.v3;

import com.vic.designpattern.strategy.v1.CalcPrice;

/**
 * 超级会员
 * @author 罗利华
 * date: 2019/8/30 13:38
 */
@PriceRange(min = 1000, max = 3000)
public class SuperMember implements CalcPrice {

    @Override
    public double calc(double price) {
        return price * 0.8;
    }
}
