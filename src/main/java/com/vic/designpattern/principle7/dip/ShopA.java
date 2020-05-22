package com.vic.designpattern.principle7.dip;

/**
 * 商店A
 * @author 罗利华
 * date: 2020/3/11 15:22
 */
public class ShopA implements Shop {

    @Override
    public String sell() {
        return "ShopA卖苹果、香蕉";
    }
}
