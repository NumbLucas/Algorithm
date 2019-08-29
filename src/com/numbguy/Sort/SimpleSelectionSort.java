package com.numbguy.Sort;

public class SimpleSelectionSort {
    public static void simpleSelectionSort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            for(int j = i+1;j<data.length - 1;j++) {
                if(data[j] <= data[i]) {
                    Utils.swap(data, i, j);
                    System.out.println("");
                }
            }
        }
    }
}
