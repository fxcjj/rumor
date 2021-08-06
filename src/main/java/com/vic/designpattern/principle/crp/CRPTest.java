package com.vic.designpattern.principle.crp;

/**
 * 合成复用原则（Composite Reuse Principle, CRP）,又称作：组合/聚合复用原则（Composite/Aggregate Reuse Principle, CARP）
 * http://c.biancheng.net/view/1333.html
 * @author Victor
 * date: 2020/3/11 17:12
 */
public class CRPTest {
    public static void main(String[] args) {
        Car car = new GasolineCar(new Black());
        car.move();
    }
}

/**
 * 车
 */
class Car {
    Color color;

    public Car(Color color) {
        this.color = color;
    }

    public void move() {
        System.out.println("Car move");
    }
}


interface Color {

}

class White implements Color {

}
class Black implements Color {

}
class Red implements Color {

}

/**
 * 汽油汽车
 */
class GasolineCar extends Car {

    public GasolineCar(Color color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println("汽油汽车move");
    }
}

/**
 * 电动汽车
 */
class ElectricCar extends Car {

    public ElectricCar(Color color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println("电动汽车move");
    }
}

