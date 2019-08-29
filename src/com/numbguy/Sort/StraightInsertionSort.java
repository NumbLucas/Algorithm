package com.numbguy.Sort;

public class StraightInsertionSort {
    public static  void straightInsertionSort(int[] data) {
        int flag = 0;
        for (int i = 1; i < data.length - 1; i++) {
            if(data[i] < data[i-1]) {
                flag = data[i];
                int j = 0;
                for(j = i - 1;j>=0&&data[j] > flag;j--) {
                    data[j+1] = data[j];
                }
                data[j+1] = flag;
            }
        }
    }
}
