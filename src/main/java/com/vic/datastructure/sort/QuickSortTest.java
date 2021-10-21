package com.vic.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 基本思想：分治（Divide-and-Conquer）和递归（Recursive）的方法。
 * 1. 先从数列中选取一个数作为基准数
 * 2. 将比基准数大的数全放到它的右边，将比基准数小的数全放到它的左边
 * 3. 再对左、右区间重复第2步，直到区间内只有一个数
 *
 * References
 * https://www.jianshu.com/p/5f38dd54b11f
 * https://blog.csdn.net/morewindows/article/details/6684558
 * 
 * @author victor
 */
public class QuickSortTest {

	public static void main(String[] args) {

		int[] a = {16, 12, 15, 16, 73, 21, 8, 9, 16, 32};

		quickSort(a, 0, a.length - 1);

		System.out.println(Arrays.toString(a));
	}

	/**
	 * 分割及递归
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static void quickSort(int[] arr, int left, int right) {
		// 只有当元素大于等于2时，才进行。一个元素本身就是自然有序，不需要处理
		if(left < right) {
			// 对数组进行分割，取出分割后的中间位置
			int basePos = partition(arr, left, right);
			// 对中间位置的左半区再次分割
			quickSort(arr, left, basePos - 1);
			// 对中间位置的右半区再次分割
			quickSort(arr, basePos + 1, right);
		}
	}

	/**
	 * 返回调整后基准数的位置
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] arr, int left, int right) {

		int i = left;
		int j = right;
		// 取left位置上数，那么a[left]就是第一个坑
		int base = arr[left];

		while(i < j) {
			/**
			 * i < j表示（左下标 < 右下标）时执行
			 * a[j] >= base表示只有当a[j]的值大于或等于base时，执行j--，当相等时，没有将a[j]放到前面的坑里，少了一次赋值操作
			 * 从右往左找第一个小于base的数来填a[i]
			 */
			while(i < j && arr[j] >= base) {
				j--;
			}
			if(i < j) {
				// 将小于或等于base的a[j]值放到之前的坑a[i]上，这样a[j]成了一个新的坑
				arr[i] = arr[j];
				i++;
			}


			/**
			 * i < j表示不相等时执行
			 * a[i] <= base表示只有当a[i]的值小于或等于base，i++，当相等时，没有将a[i]放到后面的坑里，少了一次赋值操作
			 * 从左往右找大于x的数来填a[j]
			 */
			while(i < j && arr[i] <= base) {
				i++;
			}

			if(i < j) {
				arr[j] = arr[i];
				j--;
			}
		}

		// 退出时，i等于j，将base填到a[i]坑
		arr[i] = base;
		return i;
	}

}
