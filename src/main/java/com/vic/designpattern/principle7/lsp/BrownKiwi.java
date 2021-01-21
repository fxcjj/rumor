package com.vic.designpattern.principle7.lsp;

/**
 * 几维鸟
 * 由继承 Bird 改为 Animal，因为几维鸟不会飞，所以没有飞行速度，但动物都有奔跑的速度
 * @author Victor
 * date: 2020/3/11 14:47
 */
public class BrownKiwi extends Animal {

    /**
     * 覆盖了父类中的方法，不符合里氏替换原则
     * @param speed
     */
//    @Override
//    public void setSpeed(double speed) {
//        this.flySpeed = 0;
//    }
}
