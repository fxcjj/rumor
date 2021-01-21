package com.vic.generics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * https://juejin.im/post/5d5789d26fb9a06ad0056bd9
 *
 */
//public class Test<W extends String> {
public class Test<W> {
	W value;
	
	public void add(W w) {
		
	}
	
	public static void main(String[] args) {
		Test<String> t = new Test<String>();
		Class<? extends Test> clazz = t.getClass();

		System.out.println(clazz.getName());

		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields) {
			/*
			 * 在泛型类被类型擦除的时候，如果类型参数未指定上限，则会把<W>转译为Object类型。
			 * 如果指定了上限，如<W extends String>则会转换为上限类型,即String.
			 */
			System.out.println("field: " + f);
		}
		
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods) {
			/*
			 * public static void cn.rumor.base.generic.Test.main(java.lang.String[])
				public void cn.rumor.base.generic.Test.add(java.lang.Object)
			 */
			System.out.println("method: " + m);
		}
		
		
//		List<Integer>[] li2 = new ArrayList<Integer>[];
//		List<Boolean> li3 = new ArrayList<Boolean>[];
		
		List<?>[] li3 = new ArrayList<?>[10];
		li3[1] = new ArrayList<String>();
		List<?> v = li3[1];
		
	}
}
