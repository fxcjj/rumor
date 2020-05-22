package com.vic.designpattern.principle7.dip;

/**
 * 商店B
 * @author 罗利华
 * date: 2020/3/11 15:22
 */
public class ShopB implements Shop {

    @Override
    public String sell() {
        return "ShopB卖炸弹、坦克";
    }
}
