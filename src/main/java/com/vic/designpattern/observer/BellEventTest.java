package com.vic.designpattern.observer;

import java.util.*;

/**
 * 观察者模式
 * http://c.biancheng.net/view/1390.html
 */
public class BellEventTest {

    public static void main(String[] args) {

        // 事件源：铃
        BellEventSource eventSource = new BellEventSource();

        // 注册监听器，老师、学生
        eventSource.add(new TeacherEventListener());
        eventSource.add(new StudentEventListener());

        // 打上课铃
        eventSource.ring(true);
        System.out.println("--------------");
        // 打下课铃
        eventSource.ring(false);

    }
}

// 铃声事件类：用于封装事件源及一些与事件相关的参数
class RingEvent extends EventObject {

    private boolean sound; // true表示上课，false表示下课

    public RingEvent(Object source, boolean sound) {
        super(source);
        this.sound = sound;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }
}

// 具体主题，事件源：铃
class BellEventSource {
    private List<BellEventListener> listeners; // 监听器

    public BellEventSource() {
        listeners = new ArrayList<>();
    }

    // 给事件源绑定监听器
    public void add(BellEventListener listener) {
        listeners.add(listener);
    }

    // 事件触发器：敲铃，当铃声sound的值发生变化时，通知该事件源上绑定的监听器
    public void ring(boolean sound) {
        String type = sound ? "上课铃" : "下课铃";
        System.out.println(type + "响");
        RingEvent ringEvent = new RingEvent(this, sound);

        // 通知该事件源上的所有监听器
        notifyObserver(ringEvent);
    }

    // 通知该事件源上的所有监听器，调用所有监听器上的“反应”方法
    public void notifyObserver(RingEvent ringEvent) {
        BellEventListener eventListener;
        Iterator<BellEventListener> iter = listeners.iterator();
        while (iter.hasNext()) {
            eventListener = iter.next();
            eventListener.heardBell(ringEvent);
        }
    }


}


// 抽象观察者类，铃声事件监听器
interface BellEventListener extends EventListener {
    // 事件处理方法，听到铃声
    void heardBell(RingEvent ringEvent);
}

// 具体观察者类，老师事件监听器
class TeacherEventListener implements BellEventListener {
    @Override
    public void heardBell(RingEvent ringEvent) {
        if(ringEvent.isSound()) {
            System.out.println("老师上课了");
        } else {
            System.out.println("老师下课了");
        }
    }
}

// 具体观察者类，学生事件监听器
class StudentEventListener implements BellEventListener {
    @Override
    public void heardBell(RingEvent ringEvent) {
        if(ringEvent.isSound()) {
            System.out.println("同学们，上课了");
        } else {
            System.out.println("同学们，下课了");
        }
    }
}