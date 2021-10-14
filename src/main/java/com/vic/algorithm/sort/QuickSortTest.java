package com.vic.algorithm.sort;

/**
 * 快速排序
 * 
 * References
 * https://www.jianshu.com/p/5f38dd54b11f
 * https://blog.csdn.net/morewindows/article/details/6684558
 * 
 * @author Victor
 */
public class QuickSortTest {
	
	/**
	 * 1 取一个基准数
	 * 2 i = low, j = high, x = arr[i]
	 * 3 此时arr[i]挖了坑，x与arr[j]比较，如果小于或等于x，将arr[j]填到arr[i]
	 * 4 此时i++，x与arr[i]比较，如果大于x，将arr[i]填到arr[j]
	 * 5 当i==j时，将arr[i] = x
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] a = {16, 12, 15, 16, 73, 21, 8, 9, 16, 32};
		
		quickSort(a, 0, a.length - 1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	
	/**
	 * 返回调整后基准数的位置
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static void quickSort(int[] a, int left, int right) {
		
		if(left < right) {
		
			int i = left;
			int j = right;
			int x = a[left]; //挖个坑，a[left]就是第一个坑
			
			while(i < j) {
				/**
				 * i < j表示不相等时执行
				 * a[j] >= x表示只有当a[j]的值大于或等于x时，执行j--，当相等时，没有将a[j]放到前面的坑里，少了一次赋值操作
				 * 从右往左找第一个小于x的数来填a[i]
				 */
				while(i < j && a[j] >= x) {
					j--;
				}
				if(i < j) {
					a[i] = a[j]; //将小于或等于x的a[j]值放到之前的坑a[i]上，这样a[j]成了一个新的坑
					i++;
				}
				
				
				/**
				 * i < j表示不相等时执行
				 * a[i] <= x表示只有当a[i]的值小于或等于x，i++，当相等时，没有将a[i]放到后面的坑里，少了一次赋值操作
				 * 从左往右找大于x的数来填a[j]
				 */
				while(i < j && a[i] <= x) {
					i++;
				}
				
				if(i < j) {
					a[j] = a[i];
					j--;
				}
			}
			
			//退出时，i等于j，将x填到a[i]坑
			a[i] = x;
			
			quickSort(a, left, i - 1); //递归调用
			quickSort(a, i + 1, right);
		}
	}
	
}
