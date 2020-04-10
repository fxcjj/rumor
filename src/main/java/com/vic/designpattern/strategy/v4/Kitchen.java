package com.vic.designpattern.strategy.v4;

/**
 * 环境类：厨房
 * @author 罗利华
 * date: 2020/3/12 11:19
 */
public class Kitchen {
    // 抽象策略
    private CrabCooking strategy;

    public CrabCooking getStrategy() {
        return strategy;
    }

    public void setStrategy(CrabCooking strategy) {
        this.strategy = strategy;
    }

    public void cookingMethod() {
        this.strategy.cookingMethod(); // 做菜
    }
}
