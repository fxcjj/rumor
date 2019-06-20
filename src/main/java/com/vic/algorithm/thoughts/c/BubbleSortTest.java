package com.vic.algorithm.thoughts.c;

/**
 * 冒泡排序
 * 
 * References
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 * 
 * @author Victor
 */
public class BubbleSortTest {

	public static void main(String[] args) {
		
		int[] arr = {4, 5, 1, 2, 9, 0};
		
		//起始位置为1
		for(int i = 1; i < arr.length; i++) {
			
			/**
			 * -i是因为循环一次，最后一位已是最大数，不必再次比较
			 */
			for(int j = 0; j < arr.length - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
