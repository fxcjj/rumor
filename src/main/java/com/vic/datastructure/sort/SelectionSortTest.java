package com.vic.datastructure.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 取一个变量min作为假设的最小值下标，取值为每轮循环的第一个元素的下标，与其后的所有元素比较，将找到的最小值的下标赋值给min。
 * 在本轮循环中，如果min == i，说明本轮循环的第一个元素是最小值，
 * 如果min != i，说明在其后找到了最小值，则进行交换（即将找到的最小值放到本轮循环的开始位置，将开始位置的元素放到最小值的位置）。
 *
 * @author victor
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        int[] arr = {8, 1, 4, 3, 5, 7, 9};
        selectionSort(arr, arr.length);
    }

    private static void selectionSort(int[] arr, int len) {
        // 最小值的下标
        int min;
        for(int i = 0; i < len; i++) {
            // 假设下标i为最小值的下标
            min = i;
            // i位置 之后的元素
            for(int j = i + 1; j < len; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
            System.out.println("第" + (i+1) + "趟：" + Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
