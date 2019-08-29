package com.numbguy.SordOffer;

/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，
使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
*/

import java.util.ArrayList;

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> rst = new ArrayList<>();
        for(int i = 0;i < array.length;i++) {
            for(int j = i;j < array.length;j++) {
                if(array[i] + array[j] == sum&&array[i]*array[j] < min) {
                    min = array[i]*array[j];
                    rst.add(array[i]);
                    rst.add(array[j]);
                }
            }
        }
        return rst;

    }
}
