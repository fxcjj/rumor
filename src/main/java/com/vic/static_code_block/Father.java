package com.vic.static_code_block;

public class Father {


    {
        System.out.println("Father non static code block");
    }

    static {
        System.out.println("Father static code block");
    }

    public Father() {
        System.out.println("Father constructor");
    }


    public static void main(String[] args) {
        System.out.println("Father main method");
        new Son1();
        new Son1();
    }
}
