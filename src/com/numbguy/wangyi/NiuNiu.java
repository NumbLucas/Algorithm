package com.numbguy.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/*
题目描述
为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，
牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，
牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。

输入描述:
每个输入包含一个测试用例。
每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
保证不存在两项工作的报酬相同。
输出描述:
对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。

示例1

输入

3 3 
1 100 
10 1000 
1000000000 1001 
9 10 1000000000

输出

100 
1000 
1001
*/
public class NiuNiu {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap();

        Scanner sc = new Scanner(System.in);
        int jobNum = sc.nextInt();
        int jobSeekerNum = sc.nextInt();

        int[] jobDifficulty = new int[jobNum];
        int[] jobPay = new int[jobNum];
        int[] jobSeekerCap =  new int[jobSeekerNum];
        int[] rst = new int[jobSeekerNum];
        String s  = sc.nextLine();

        for (int i = 0; i < jobNum; i++) {
            jobDifficulty[i] = sc.nextInt();
            jobPay[i] = sc.nextInt();
            if((!map.containsKey(jobDifficulty[i]))||
                    (map.containsKey(jobDifficulty[i])&&map.get(jobDifficulty[i])<jobPay[i]))
                map.put(jobDifficulty[i], jobPay[i]);
        }
        
        Arrays.sort(jobDifficulty);

        int max = map.get(jobDifficulty[0]);
        for (int i = 0; i < jobNum; i++) {
            if(max > map.get(jobDifficulty[i])) {
                map.put(jobDifficulty[i], max);
            }else{
                max = map.get(jobDifficulty[i]);
            }
        }

        for (int i = 0; i < jobSeekerNum; i++) {
            jobSeekerCap[i] = sc.nextInt();
        }

        for (int i = 0; i < jobSeekerNum; i++) {
            int capability = jobSeekerCap[i];
            if(map.containsKey(capability)) {
                rst[i] = map.get(capability);
            }else {
                int index = -(Arrays.binarySearch(jobDifficulty, capability)+2);
                if(index>=0)
                    rst[i] = map.get(jobDifficulty[index]);
                else
                    rst[i] = 0;
            }
        }

        for (int i = 0; i < jobSeekerNum; i++) {
            System.out.println(rst[i]);
        }
        System.out.println("");
    }
}