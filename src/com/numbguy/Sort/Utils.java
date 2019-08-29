package com.numbguy.Sort;

import java.util.Random;

public class Utils {
    public static void swap(int[] data, int i, int j) {
        int tmp = 0;
        tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf(data[i] + " ");
        }
        System.out.println(" ");
    }

    public static int[] generateArray(int size, int maxRandomNum) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = new Random().nextInt(maxRandomNum);
        }
        return data;
    }
}
