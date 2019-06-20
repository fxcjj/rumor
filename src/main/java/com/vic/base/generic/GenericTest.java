package com.vic.base.generic;

import java.util.ArrayList;

public class GenericTest {
	public static void main(String[] args) {
//        test01();
		
    }

	private static void test01() {
		ArrayList<String> al = new ArrayList<String>();
        al.add("a");
        al.add("b");
        accept(al);
	}

    public static void accept(ArrayList<?> al) {
//	public static void accept(ArrayList<Object> al) { //error
        for (Object o : al)
            System.out.println(o);
    }
}
