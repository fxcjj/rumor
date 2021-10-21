package com.vic.datastructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 大顶堆：每一个结点都比它的左孩子、右孩子的值大
 * 小顶堆：每一个结点都比它的左孩子、右孩子的值小
 *
 * 1. 建堆
 * 2. 维护（大顶或小顶）堆的性质
 * 3. 排序
 *
 * 大顶堆
 * 下标为i的节点的父节点下标：(i - 1)/2，整数除法
 * 下标为i的节点的左孩子下标：i * 2 + 1
 * 下标为i的节点的右孩子下标：i * 2 + 2
 *
 * @author luolihua
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int [] arr = {23, 6, 5, 3, 1, 2, 9, 7};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * @param arr 存储堆的数组
     * @param n 数组长度
     */
    static void heapSort(int [] arr, int n) {
        // 建堆
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 排序
        for(int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }


    /**
     * 维护堆的性质
     * @param arr 存储堆的数组
     * @param n 数组长度
     * @param i 待维护节点的下标
     */
    static void heapify(int [] arr, int n, int i) {
        int largest = i;
        int lson = i * 2 + 1;
        int rson = i * 2 + 2;
        if(lson < n && arr[largest] < arr[lson]) {
            largest = lson;
        }
        if(rson < n && arr[largest] < arr[rson]) {
            largest = rson;
        }
        if(largest != i) {
             swap(arr, largest, i);
             heapify(arr, n, largest);
        }
    }

    static void swap(int[] arr, int largest, int i) {
        int t = arr[largest];
        arr[largest] = arr[i];
        arr[i] = t;
    }


}
