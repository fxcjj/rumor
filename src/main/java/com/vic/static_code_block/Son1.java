package com.vic.static_code_block;

public class Son1 extends Father {

    {
        System.out.println("Son1 non static code block");
    }

    static {
        System.out.println("Son1 static code block");
    }

    public Son1() {
        System.out.println("Son1 constructor");
    }


    public static void main(String[] args) {
        System.out.println("Son1 main method");
        new Son1();
    }
}
