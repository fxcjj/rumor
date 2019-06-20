package com.vic.base.generic;

public class Test3<T> {
	
	/**
	 * 普通方法
	 * @param t
	 */
	public void v1(T t) {
	}
	
	/**
	 * 泛型方法
	 * @param t
	 * @return
	 */
	public <E> E v2(E e) {
		return e;
	}
	
	public static void main(String[] args) {
		Test3<String> t = new Test3<String>();
		t.v1("prosperity");
//		t.v1(32); //compilation error
		
		Integer v2 = t.v2(new Integer(1));
		
		
	}
}
