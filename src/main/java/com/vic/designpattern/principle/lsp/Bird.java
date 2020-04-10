package com.vic.designpattern.principle.lsp;

/**
 * 鸟
 * @author 罗利华
 * date: 2020/3/11 14:44
 */
public class Bird {

    /**
     * 飞行速度
     */
    double flySpeed;

    public void setSpeed(double speed) {
        this.flySpeed = speed;
    }

    public double getFlyTime(double distance) {
        return distance/flySpeed;
    }
}
