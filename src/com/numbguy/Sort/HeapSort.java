package com.numbguy.Sort;

public class HeapSort {
    public static void heapSort(int[] data) {
        Utils.printArray(data);

        for(int i = data.length/2-1;i >= 0;i--) {
            heapAdjust(data, i, data.length-1);
        }

        for(int i =data.length -1;i >= 0;i--) {

            Utils.swap(data, 0, i);
            heapAdjust(data, 0, i-1);

        }
    }

    public static void heapAdjust(int[] data, int index, int end) {
        int left = 2*index + 1;
        int right = 2*index + 2;

        while(left <= end) {
            int largeIndex;
            if(right <= end&& data[right] > data[left]) {
                largeIndex = right;
            }else {
                largeIndex = left;
            }

            if(data[largeIndex] < data[index]) {
                break;
            }

            Utils.swap(data, largeIndex, index);

            index = largeIndex;
            left = 2*index + 1;
            right = 2*index + 2;

        }
    }
}
