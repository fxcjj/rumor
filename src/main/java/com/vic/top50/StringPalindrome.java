package com.vic.top50;

/**
 * You need to write a simple Java program to check 
 * if a given String is palindrome or not. 
 * A Palindrome is a String which is equal to the reverse 
 * of itself e.g. "Bob" is a palindrome because of the reverse of "Bob" is also "Bob".  
 * Though be prepared with both recursive and iterative solution of this problem. 
 * The interviewer may ask you to solve without using any library method e.g. indexOf() 
 * or subString() so be prepared for that.
 * 
 * @author Victor
 * @date 2018年4月11日 下午8:09:16
 */
public class StringPalindrome {

	
	public static void main(String[] args) {
		String a = "andna";
		System.out.println(isPalindrome(a.toCharArray()));
	}
	
	
	public static boolean isPalindrome(char[] word) {
		
		int start = 0;
		int end = word.length - 1;
		
		while(end > start) {
			if(word[start] != word[end]) {
				return false;
			}
			++start;
			--end;
		}
		
		return true;
	}

}
