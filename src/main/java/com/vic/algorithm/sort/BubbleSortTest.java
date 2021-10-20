package com.vic.algorithm.sort;

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
		
		int[] arr1 = {4, 5, 1, 2, 9, 0};

		/**
		 * 外层循环次数从 1 到 arr.length - 1
		 */
		bubbleSort1(arr1);
		printArr(arr1);
		System.out.println();


		/**
		 * 外层循环次数从 arr.length 到 2
		 */
		int [] arr2 = {3, 7, 2, 1, 9, 8};
		bubbleSort2(arr2);
		printArr(arr2);


	}

	private static void bubbleSort2(int[] arr) {
		int len = arr.length;
		// i>1，表示内层循环处理了2个元素后，还剩下一个不用再处理，即自然有序
		for(int i = len; i > 1; i--) {
			boolean swap = false;
			for(int j = 1; j < i; j++) {
				if(arr[j-1] > arr[j]) {
					int t = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = t;
					swap = true;
				}
			}
			// 处理外层每一次循环时，如果没有发生交换则表示有序，无需再往后循环，直接break
			if(!swap) {
				break;
			}
			System.out.print("第" + (len - i + 1) + "趟排序：");
			printArr(arr);
		}
	}

	private static void bubbleSort1(int[] arr) {
		// 起始位置为1
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
			System.out.print("第" + i + "趟排序：");
			printArr(arr);
		}
	}

	private static void printArr(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
