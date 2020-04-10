package com.vic.generic;

public class Test3<T> {
	
	/**
	 * 普通方法
	 * @param t 类型要和类上标记的泛型类一致
	 */
	public void v1(T t) {
	}
	
	/**
	 * 泛型方法
	 * <E> 通过它来保证泛型参数的一致性
	 * @param e1
	 * @param e2
	 * @return
	 */
	public <E> E v2(E e1, E e2) {
		if(e1 == e2) {
			return e1;
		}
		return e2;
	}
	
	public static void main(String[] args) {
		Test3<String> t = new Test3<String>();
		t.v1("prosperity");
//		t.v1(32); //compilation error

		Integer e1 = new Integer(1);
		Integer e2 = new Integer(2);

		Long e3 = new Long(1);

		Integer v2 = t.v2(e1, e2);
		
		
	}
}
