package com.vic.designpattern.principle.solid.dip;

/**
 * 商店A
 * @author Victor
 * date: 2020/3/11 15:22
 */
public class ShopA implements Shop {

    @Override
    public String sell() {
        return "ShopA卖苹果、香蕉";
    }
}
