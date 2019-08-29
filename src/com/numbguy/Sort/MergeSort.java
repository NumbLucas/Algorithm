package com.numbguy.Sort;

public class MergeSort {
    public static void MergeSort(int[] data) {
        MergeSort_1(data, data, 0, data.length-1);
    }

    public static void MergeSort_1(int[] data, int[] rst, int start, int end) {
        int mid = (start + end)/2;
        int[] assit = new int[data.length];
        if(start == end)
            rst[start] = data[start];
        else {
            MergeSort_1(data, assit, start, mid);
            MergeSort_1(data, assit, mid + 1, end);
            Merge(assit, rst, start, mid, end);
        }
    }

    public static void Merge(int[] data, int[] rst, int start, int mid, int end) {
        int i,j,k;
        for(j = start, k = mid + 1,i = start;j<=mid&&k <=end;i++) {
            if(data[j] < data[k])
                rst[i] = data[j++];
            else
                rst[i] = data[k++];
        }

        if(j <= mid) {
            for(;j <= mid;) {
                rst[i++] = data[j++];
            }
        }else {
            for(;k <= end;) {
                rst[i++] = data[k++];
            }
        }
    }


    //Sort 2 非递归方式

    public static void MergeSort_2(int[] data) {
        int k = 1;
        int[] assit = new int[data.length];

        while(k < data.length) {
            MergePass(data, assit, k, data.length);
            k*=2;
            MergePass(assit, data, k, data.length);
            k*=2;
        }
    }
    public static void MergePass(int[] data,int[] rst, int s, int length) {
        int i,j;
        int start, mid, end;

        for(i = 0;i < length/(2*s);i++) {
            Merge(data, rst, i*2*s, i*2*s+ s -1, i*2*s+2*s -1);
        }

        if(length%(2*s) != 0) {
            start = length - length%(2*s);
            end = length -1;
            mid = (start + end)/2;
            Merge(data, rst, start, mid, end);
        }

    }
}
