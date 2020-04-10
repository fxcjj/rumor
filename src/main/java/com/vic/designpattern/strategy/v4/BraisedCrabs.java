package com.vic.designpattern.strategy.v4;

import javax.swing.*;

/**
 * 具体策略类：红烧大闸蟹
 * @author 罗利华
 * date: 2020/3/12 11:16
 */
public class BraisedCrabs extends JLabel implements CrabCooking {

    @Override
    public void cookingMethod() {
//        this.setIcon(new ImageIcon("D:\\note\\design-pattern\\BraisedCrabs.jpg"));
//        this.setIcon(new ImageIcon("D:\\github\\rumor\\src\\main\\java\\com\\vic\\designpattern\\strategy\\v4\\BraisedCrabs.jpg"));
        this.setIcon(new ImageIcon("com/vic/designpattern/strategy/v4/BraisedCrabs.jpg"));
        this.setHorizontalAlignment(CENTER);
    }

}
