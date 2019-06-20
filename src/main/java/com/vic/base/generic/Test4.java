package com.vic.base.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test4<T> {
	
	/**
	 * 有上限的通配符
	 * @param c
	 */
	public static void print1(Collection<? extends Father> c) {
		//丧失了写能力
//		c.add(new Son1()); //compilation error
//		c.add(new Son2()); //compilation error
		
		Iterator<? extends Father> iter = c.iterator();
		while(iter.hasNext()) {
			Father next = iter.next();
			System.out.println(next);
		}
	}
	
	/**
	 * 有下限的通配符
	 * @param c
	 */
	public static void print2(Collection<? super Son1> c) {
		//丧失部分写能力
		c.add(new Son1("3")); //ok
//		c.add(new Father("f")); //compilation error
		
		Iterator<? super Son1> iter = c.iterator();
		while(iter.hasNext()) {
			Object next = iter.next();
			System.out.println(next);
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		List<Son1> list1 = new ArrayList<Son1>();
		list1.add(new Son1("1"));
		list1.add(new Son1("2"));
		
//		print1(list1);
		
//		print2(list1);
		
		List<Integer> l1 = new ArrayList<Integer>();
		List<String> l2 = new ArrayList<String>();
		
		System.out.println(l1.getClass() == l2.getClass());
		
		
	}
}
