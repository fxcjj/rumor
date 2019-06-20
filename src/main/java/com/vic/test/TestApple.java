package com.vic.test;

import com.vic.entity.Apple;
import com.vic.entity.Fruit;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * @author Victor
*/
public class TestApple {
	
	public static void main(String[] args) throws Exception {
		//testHE();
		
		//getProperty(new Apple("black"), "color");
//		new Apple("black", "1");
//		getStaticProperty("cn.vic.entity.Apple", "weight");
		
		//invokeMethod(new Apple(), "hi", new Object[]{"victor"});
		
		//invokeStaticMethod("cn.vic.entity.Apple", "print", new Object[]{});
		
		//newInstance("cn.vic.entity.Apple", new Object[]{"red", "1"});
		
		//isInstance(new Apple(), Apple.class);
		
		//getByArray(new Object[]{"a", 1, 'c', 4.7f, 3.4d}, 2);
		
	}
	
	private static void testGetClass() {
		Fruit f = new Fruit();
		Apple a = new Apple();
		f = a;
		System.out.println(f.getClass()); //class cn.vic.entity.Apple
	}
	
	private static void getByArray(Object array, int index) {
		Object object = Array.get(array, index);
		System.out.println(object);
	}
	
	private static void isInstance(Object obj, Class clazz) throws  Exception {
		System.out.println(clazz.isInstance(obj));
	}

	private static void newInstance(String className, Object[] args) throws  Exception {
		Class<?> clazz = Class.forName(className);
		Class[] argsClass = null;
		if(args != null && args.length > 0) {
			argsClass = new Class[args.length];
			for(int i = 0; i < args.length; i++) {
				argsClass[i] = args[i].getClass();
			}
		}
		Constructor<?> cons = clazz.getConstructor(argsClass); //clazz.getConstructor() 
		Object obj = cons.newInstance(args); //执行带参数的构造函数
		System.out.println(obj);
	}
	
	
	private static void invokeStaticMethod(String className, String methodName, Object[] args) throws  Exception {
		Class<?> clazz = Class.forName(className);
		Class[] argsClass = null;
		if(args != null && args.length > 0) {
			argsClass = new Class[args.length];
			for(int i = 0; i < args.length; i++) {
				argsClass[i] = args[i].getClass();
			}
		}
		Method method = clazz.getMethod(methodName, argsClass);
		Object methodValue = method.invoke(null, args);
		System.out.println(methodValue);
	}
	
	private static void invokeMethod(Object owner, String methodName, Object[] args) throws  Exception {
		Class<? extends Object> ownerClass = owner.getClass();
		Class[] argsClass = null;
		if(args != null && args.length > 0) {
			argsClass = new Class[args.length];
			for(int i = 0; i < args.length; i++) {
				argsClass[i] = args[i].getClass();
			}
		}
		Method method = ownerClass.getMethod(methodName, argsClass);
		Object methodValue = method.invoke(owner, args);
		System.out.println(methodValue);
	}
	
	private static void getStaticProperty(String className, String fieldName) throws  Exception {
		Class<?> ownerClass = Class.forName(className);
		Field field = ownerClass.getField(fieldName);
		Object property = field.get(ownerClass); //get static property, exist in Class
		System.out.println(property);
	}
	
	private static void getProperty(Object owner, String fieldName) throws  Exception {
		Class<? extends Object> ownerClass = owner.getClass();
		Field field = ownerClass.getField(fieldName);
		Object property = field.get(owner); //get property, exist in Object
		System.out.println(property);
	}
	
}
