package com.vic.designpattern.principle7.dip;

/**
 * @author Victor
 * date: 2020/3/11 15:19
 */
public class Customer {

    /**
     * Customer和Shop是依赖关系
     * 耦合度最弱的一种关联方式
     * 这里参数不要使用细节（即具体的实现类），而要使用接口或抽象类
     * @param shop
     */
    public void shopping(Shop shop) {
        // 购物
        System.out.println(shop.sell());
    }

}
