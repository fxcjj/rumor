package com.vic.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * http://c.biancheng.net/view/1390.html
 */
public class ObserverPattern1 {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();

        // 添加观察者
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subject.add(observer1);
        subject.add(observer2);

        //
        subject.notifyObserver();


    }


}

/**
 * 抽象主题
 */
abstract class Subject {
    List<Observer> observers = new ArrayList<>();

    // 增加观察者
    public void add(Observer observer) {
        observers.add(observer);
    }

    // 删除观察者
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    // 通知观察者
    public abstract void notifyObserver();

}

/**
 * 具体主题
 */
class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        System.out.println("具体主题 执行");
        // 遍历 observers，调用每一个 response 方法
        observers.forEach(e -> e.response());
    }
}

/**
 * 抽象观察者
 */
interface Observer {
    void response(); // 反应
}

/**
 * 具体观察者1
 */
class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者1 作出反应");
    }
}

/**
 * 具体观察者2
 */
class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者2 作出反应");
    }
}

