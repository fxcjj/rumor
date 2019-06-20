package com.vic.test;


public class Def {

    private int[] arr = new int[6];
    
    private int idx;
    
    public synchronized int push(int data) throws InterruptedException {
        //不能再放了，等待pop
        while(arr.length >= 6) {
            this.wait();
        }
        System.out.println("push"+data);
        arr[idx] = data;
        return idx++;
    }
    
    public synchronized int pop() {
        this.notify();
        idx--;
        System.out.println("pop"+arr[idx]);
        return arr[idx];
    }
    
    public static void main(String[] args) {
        final Def def = new Def();
        new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i = 0; i < 10; i++) {
                        def.push(i);
                    }
                } catch (InterruptedException e) {
                }
            }
        }).start();;
        
        new Thread(new Runnable() {
            public void run() {
                for(int j = 0; j < 10; j++) {
                    System.out.println(def.pop());
                }
            }
        }).start();
        
        
    }
    
}

