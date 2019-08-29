package com.numbguy;

import com.numbguy.Sort.*;

import java.io.Reader;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] data = Utils.generateArray(8, 50);
        data = new int[]{19, 46, 41, 22, 42, 31, 26, 91, 19, 19, 9, 5, 2, 50 };
        System.out.println("original data: ");
        Utils.printArray(data);

        System.out.println("quickSort: ");
        QuickSort.quickSort_2(data, 0, data.length-1);
        Utils.printArray(data);

        char c = '0';
        int i = (int)c;
        System.out.println(i);

//        System.out.println("bubbleSort2: ");
//        BubbleSort.bubbleSort2(data);
//        Utils.printArray(data);

//        System.out.println("simpleSelectionSort:");
//        SimpleSelectionSort.simpleSelectionSort(data);
//        Utils.printArray(data);

//        System.out.println("straightInsertionSort:");
//        StraightInsertionSort.straightInsertionSort(data);
//        Utils.printArray(data);

//        System.out.println("heapSort:");
//        HeapSort.heapSort(data);
//        Utils.printArray(data);

//        System.out.println("MergeSort:");
//        MergeSort.MergeSort_2(data);
//        Utils.printArray(data);
    }
}
