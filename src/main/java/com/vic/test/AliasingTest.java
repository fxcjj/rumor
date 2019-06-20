package com.vic.test;
/**
 * 
 * @author Victor
*/
public class AliasingTest {
	public static void main(String[] args) {
		B[] b = new B[10];
		A[] a = b;
		
		a[0] = new A();
		b[0].print();
	}
}

class A {
	public void print() {
		System.out.println("A print()");
	}
}

class B extends A {
	
	public void print() {
		System.out.println("B print()");
	}
	
	public void info() {
		System.out.println("B info()");
	}
}
