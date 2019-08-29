package com.numbguy.Sort;

public class BubbleSort {
    public static void bubbleSort1(int[] data) {
        for (int i = 0; i < data.length -1; i++) {
            for(int j = data.length-2;j>=i;j--) {
                if(data[j] > data[j+1]) {
                    Utils.swap(data, j, j+1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] data) {
        boolean flag = true;
        for (int i = 0; i < data.length -1&&flag; i++) {
            flag = false;
            for(int j = data.length-2;j>=i;j--) {
                if(data[j] > data[j+1]) {
                    Utils.swap(data, j, j+1);
                    flag = true;
                }
            }
        }
    }


}
