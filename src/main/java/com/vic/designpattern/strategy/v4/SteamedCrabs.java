package com.vic.designpattern.strategy.v4;

import javax.swing.*;

/**
 * 具体策略类：清蒸大闸蟹
 * @author Victor
 * date: 2020/3/12 11:16
 */
public class SteamedCrabs extends JLabel implements CrabCooking {

    @Override
    public void cookingMethod() {
        this.setIcon(new ImageIcon("D:\\note\\design-pattern\\SteamedCrabs.jpg"));
//        this.setIcon(new ImageIcon("com/vic/designpattern/strategy/v4/SteamedCrabs.jpg"));
        this.setHorizontalAlignment(CENTER);
    }

}
