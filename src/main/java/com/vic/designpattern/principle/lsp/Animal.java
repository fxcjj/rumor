package com.vic.designpattern.principle.lsp;

/**
 * 动物
 * @author 罗利华
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
