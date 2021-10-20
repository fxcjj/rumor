package com.vic.algorithm.sort;

/**
 * 归并排序
 * 分治（Divide and Conquer）和递归（Recursive）的思想
 * @author luolihua
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] arr = {9, 2, 7, 6, 8, 4, 8, 12, 1};
        int[] tempArr = new int[arr.length];
        mergeSort(arr, tempArr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int[] arr, int[] tempArr, int left, int right) {
        // 当重合时，说明只有一个元素，一个元素是有序的，无需处理
        if(left < right) {
            // 找中间点
            int mid = (left + right)/2;
            // 递归划分左半区
            mergeSort(arr, tempArr, left, mid);
            // 递归划分右半区
            mergeSort(arr, tempArr, mid + 1, right);
            // 合并已经排序的
            merge(arr, tempArr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] tempArr, int left, int mid, int right) {
        // 标记左半区第一个未排序的元素
        int l_pos = left;

        // 标记右半区第一个未排序的元素
        int r_pos = mid + 1;

        // 临时数组元素的下标
        int pos = left;

        // 合并 l_pos最大值为mid，r_pos最大值为right，当其中一个达到最大值时，不再执行while
        while(l_pos <= mid && r_pos <= right) {
            // 左半区第一个元素 < 右半区第一个元素
            if(arr[l_pos] < arr[r_pos]) {
                // 将左半区小的元素放入临时数组中，并且pos加1、l_pos加1
                tempArr[pos++] = arr[l_pos++];
            } else {
                // 左半区第一个元素 >= 右半区第一个元素
                // 将右半区小（或相等）的元素放入临时数组中，并且pos加1、r_pos加1
                tempArr[pos++] = arr[r_pos++];
            }
        }

        // 合并左半区的剩余的元素
        while(l_pos <= mid) {
            tempArr[pos++] = arr[l_pos++];
        }

        // 合并右半区的剩余的元素
        while(r_pos <= right) {
            tempArr[pos++] = arr[r_pos++];
        }

        // 把临时数据中合并后的元素复制回原来的数组
        while(left <= right) {
            arr[left] = tempArr[left];
            left++;
            
            // left 为数组长度时，即不符合while条件则退出循环
        }
    }

}
