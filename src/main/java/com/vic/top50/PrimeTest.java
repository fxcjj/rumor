package com.vic.top50;

/**
 * 在大于1的整数中，只能被1和这个数本身整除的数，如2、3、5、7、11。也叫质数。
 * @author Victor
 * @date 2018年4月3日 下午4:24:11
 */
public class PrimeTest {

	public static void main(String[] args) {
		
		/**
		 * Integer.MAX_VALUE
		 * true
		 * 7620 793 497 nano
		 */
		int number = Integer.MAX_VALUE;
		
		/*long startTime = System.nanoTime();
		boolean prime = isPrime(number);
		System.out.println(prime);
				
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println(elapsedTime);*/
		
		/*for(int i = 0; i < 20; i++) {
			System.out.printf("Does %d is prime? %s, %s, %s %n", i, isPrime1(i), isPrime2(i), isPrime3(i));
		}*/
		
		long startTime = System.nanoTime();
		isPrime1(number);
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("isPrime1 elapsedTime:"+elapsedTime);
		
		long startTime1 = System.nanoTime();
		isPrime2(number);
		long elapsedTime1 = System.nanoTime() - startTime1;
		System.out.println("isPrime2 elapsedTime:"+elapsedTime1);
		
		long startTime2 = System.nanoTime();
		isPrime3(number);
		long elapsedTime2 = System.nanoTime() - startTime2;
		System.out.println("isPrime3 elapsedTime:"+elapsedTime2);
		
		/*
		 * 	isPrime1 elapsedTime:603732
			isPrime2 elapsedTime:343039
			isPrime3 elapsedTime:7680
		 */
		
	}
	
	/**
	 * Third way to check if a nubmer is prime or not
	 * @param number
	 * @return
	 */
	public static String isPrime3(int number) {
		if(number < 0) {
			return "not valid";
		}
		if(number == 0 || number == 1) {
			return "not prime";
		}
		if(number == 2 || number == 3) {
			return "prime";
		}
		if((number * number - 1) % 24 == 0) {
			return "prime";
		} else {
			return "not prime";
		}
		
		
	}
	/**
	 * Second version of isPrime2 method, with improvement like not 
	 * checking for division by even number, if its not divisible by 2 
	 * @param number
	 * @return
	 */
	public static boolean isPrime2(int number) {
		if(number == 2 || number == 3) {
			return true;
		}
		if(number % 2 == 0) {
			return false;
		}
		int sqrt = (int)Math.sqrt(number) + 1;
		for(int i = 3; i < sqrt; i+=2) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Java method to check if an integer number is prime or not
	 * @param number
	 * @return true if number is prime, else false
	 */
	public static boolean isPrime1(int number) {
		int sqrt = (int)Math.sqrt(number) + 1;
		for(int i = 2; i < sqrt; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * low performance
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		if(n == 1)
			return false;
		
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	
	/*public static boolean isPrime(int n) {
		if (n <= 3)
			return n > 1;
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}*/
	
	/*private static boolean isArmStrong(int number) {
		int result = 0;
		int orig = number;
		while(number != 0) {
			int remainder = number%10;
			result = result + remainder*remainder*remainder;
			number = number/10;
		} //number is Armstrong return true
		if(orig == result) {
			return true;
		}
		return false;
	} */
	
	

}
