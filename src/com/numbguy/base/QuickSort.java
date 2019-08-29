package com.numbguy.base;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {

        if(low < high) {
            int index = partition(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        int flag = arr[low];

        while(low < high) {
            while(low < high&&arr[high]>=flag)
                high--;
            swap(arr, low, high);
            while(low < high&&arr[low]<=flag)
                low++;
            swap(arr, low, high);
        }

        return low;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2,1};
        //quickSort(a, 0, 4);

        for (int i = 0; i < a.length; i++) {
            //System.out.println(a[i]);
        }

        System.out.println( Arrays.binarySearch(a, 3));
    }
}
