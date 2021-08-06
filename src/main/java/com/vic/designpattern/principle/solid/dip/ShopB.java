package com.vic.designpattern.principle.solid.dip;

/**
 * 商店B
 * @author Victor
 * date: 2020/3/11 15:22
 */
public class ShopB implements Shop {

    @Override
    public String sell() {
        return "ShopB卖炸弹、坦克";
    }
}
