package com.vic.algorithm.thoughts.c;

public class InsertTest {

	public static void main(String[] args) {
		int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过选择排序后的数组顺序为：");
        display(array);
	}
	
	public static int[] sort(int[] array) {
		
		int j;
		for(int i = 1; i < array.length; i++) {
			int tmp = array[i];
			
			j = i;
			//找出比临时值大的值，然后将此值往后移一位，此时j--表示下一位（从右往左），再次循环...
			while(j > 0 && tmp < array[j-1]) {
				array[j] = array[j-1];
				j--;
			}
			
			//当跳出while循环时，说明找到了比tmp小的值，将tmp插入到此值前面
			array[j] = tmp;
			
			//第 i轮排序的结果为
            System.out.print("第" + i + "轮排序后的结果为:");
            display(array);
		}
		
		return array;
	}
	
	//遍历显示数组
    public static void display(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
