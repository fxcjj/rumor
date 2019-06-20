package com.vic.algorithm.thoughts.c;

public class ChoiceTest {

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
		//
		for(int i = 0; i < array.length; i++) {
			//选择第一个元素作为临时最小值index
			int min = i;
			
			//遍历n-1个元素，将最小值的索引赋值给min
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j; //最小值的索引赋值给min
				}
			}
			
			//有比i位置上的值更小的值，交换值，使i位置上的值最小
			if(i != min) {
				int t = array[i];
				array[i] = array[min];
				array[min] = t;
			}
			
			//第 i轮排序的结果为
            System.out.print("第" + (i+1) + "轮排序后的结果为:");
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
