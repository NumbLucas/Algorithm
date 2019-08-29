package com.numbguy.Sort;

import java.util.ArrayList;

public class QuickSort {
    public static int quickSortPartition(int[] data, int low, int high) {
        int index = low;
        int flag = data[low];

        while(low< high) {
            while(low < high && (data[high] >= flag))
                high--;
            while(low < high && (data[low] <= flag))
                low++;
            swap(data, low, high);
        }
        data[index] = data[low];
        data[low] = flag;
        return low;
    }

    public static int quickSortPartition_2(int[] data, int low, int high) {
        int flag = data[low];

        while(low< high) {
            while(low < high && (data[high] >= flag))
                high--;
            swap(data, low, high);
            while(low < high && (data[low] <= flag))
                low++;
            swap(data, low, high);
        }

        return low;
    }

    public static void swap(int[] data, int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    public static void quickSort(int[] data, int low, int high) {

        if(low < high) {
            int index = quickSortPartition_2(data, low, high);
            quickSort(data, low, index - 1);
            quickSort(data, index + 1, high);
        }
    }

    //优化递归的方式，缩减堆栈深度，提升性能

    public static void quickSort_2(int[] data, int low, int high) {

        while(low < high) {

            int index = quickSortPartition_2(data, low, high);
            quickSort_2(data, low, index - 1);
            low = index + 1;
        }
    }
}
