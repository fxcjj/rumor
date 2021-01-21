package com.vic.designpattern.principle7.lsp;

/**
 * 动物
 * @author Victor
 * date: 2020/3/11 14:56
 */
public class Animal {

    double runSpeed;

    public void setRunSpeed(double speed) {
        this.runSpeed = speed;
    }

    public double getRunTime(double distance) {
        return distance/runSpeed;
    }
}
