package com.vic.top50;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * http://www.java67.com/2016/05/fibonacci-series-in-java-using-recursion.html
 * 
 * @author Victor
 * @date 2018年4月3日 下午4:13:53
 */
public class FibonacciTest {
	
	/**
	 * cache for fibonacci
	 */
	public static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		
		
		//1
		//input to print Finonacci series upto how many numbers
		/*System.out.println("Enter number upto which Fibonacci series to print: ");
		int number = new Scanner(System.in).nextInt();
		
		System.out.println("Fibonacci series upto " + number + "numbers: ");
		
		//printing Fibonacci series upto number
		for(int i = 1; i <= number; i++) {
			System.out.println(fibonacci2(i) + " ");
		}*/
		
		//2
		//comparison of performance of fibonacci number with memorization
		int number = 10000000;
		long startTime = System.nanoTime();
		int result = fibonacci2(number); //fibonacci number without memorization
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Time taken to calculate Fibonacci number upto 100M without memorization: " + elapsedTime);
		
		startTime = System.nanoTime();
		result = improvedFibo(number); //fibonacci number with memorization
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("Time taken to calculate Fibonacci number upto 100M with memorization: " + elapsedTime);
	}
	
	/**
	 * Java program for Fibonacci number using recursion
	 * This program uses tail recursion to calculate Fibonacci number for 
	 * a given number
	 * @param number
	 * @return Fibonacci number
	 */
	private static int fibonacci(int number) {
		if(number == 1 || number == 2) {
			return 1;
		}
		return fibonacci(number - 1) + fibonacci(number - 2); 
	}
	
	/**
	 * Java program to calculate Fibonacci number useing loop or iteration
	 * @param number
	 * @return
	 */
	private static int fibonacci2(int number) {
		if(number == 1 || number == 2) {
			return 1;
		}
		
		int fibo1 = 1;
		int fibo2 = 1;
		int fibonacci = 1;
		
		for(int i = 3; i <= number; i++) {
			//Fibonacci number is sum of previous two Fibonacci number
			fibonacci = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibonacci;
		}
		return fibonacci; ////Fibonacci number 
	}
	
	
	public static int improvedFibo(int number) {
		Integer fibonacci = cache.get(number);
		if(fibonacci != null) {
			return fibonacci; //finonacci number from cache
		}
		//fibonacci number not in cache, calculating it
		fibonacci = fibonacci2(number);
		
		//putting fibonacci number in cache for future request
		cache.put(number, fibonacci);
		return fibonacci;
		
	}
}
