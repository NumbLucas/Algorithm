package com.numbguy.SordOffer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * **/
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();

        for(int i = 1;i <= sum;i++) {
            for(int j = 1;j <= sum;j++) {
                if((i+j)*(j-i+1) == sum*2) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    for(int k = i;k<=j;k++) {
                        tmp.add(k);
                    }
                    rst.add(tmp);

                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        rst = FindContinuousSequence(3);

//        for(int i = 0;i < rst.size();i++) {
//            for(int j = 0;j < rst;j++) {
//
//            }
//        }
    }
}