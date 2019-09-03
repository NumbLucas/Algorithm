package com.numbguy.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
// 小明是一名算法工程师，同时也是一名铲屎官。某天，他突发奇想，想从猫咪的视频里挖掘一些猫咪
//为了提取运动信息，他需要从视频的每一帧提取“猫咪特征”。一个猫咪特征是一个两维的vector<x, y>。
//如果x_1=x_2 and y_1=y_2，那么这俩是同一个特征。
//        因此，如果喵咪特征连续一致，可以认为喵咪在运动。也就是说，如果特征<a, b>在持续帧里出现，
//那么它将构成特征运动。比如，特征<a, b>在第2/3/4/7/8帧出现，那么该特征将形成两个特征运动2-3-4 和7-8。
// 现在，给定每一帧的特征，特征的数量可能不一样。小明期望能找到最长的特征运动。


// 每个测试用例的第一行包含一个正整数M，代表视频的帧数。

// 接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；
//比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>

// 所有用例的输入特征总数和<100000

// N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
// 特征取值均为非负整数。

// 输出描述:
// 对每一个测试用例，输出特征运动的长度作为一行

// 输入例子1:
// 1
// 8
// 2 1 1 2 2
// 2 1 1 1 4
// 2 1 1 2 2
// 2 2 2 1 4
// 0
// 0
// 1 1 1
// 1 1 1

// 输出例子1:
// 3

// 例子说明1:
// 特征<1,1>在连续的帧中连续出现3次，相比其他特征连续出现的次数大，所以输出3
public class Feature {

    /*
    思路：siluusislususlusulsulususuus   
    设f(n)表示以第n帧结束的前n帧最长特征
    */
    class Pair {
        public int value_1;
        public int value_2;

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            //result = prime * result + this.hashCode();
            result = prime * result + value_1;
            result = prime * result + value_2;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;

            if (value_1 != other.value_1)
                return false;
            if (value_2 != other.value_2)
                return false;
            return true;
        }

        public Pair(int value_1, int value_2) {
            this.value_1 = value_1;
            this.value_2 = value_2;
        }

    }

    public static void main(String[] args) { 
        Feature feature = new Feature(); 
        
        Scanner sc = new Scanner(System.in);
        int exampleNum = sc.nextInt();
        
        for (int i = 0; i < exampleNum; i++) {
            int frameNum = sc.nextInt();
          
            ArrayList<Pair[]> arr = new ArrayList<>(); 
            for (int j = 0; j < frameNum; j++) {
                int featureNum = sc.nextInt();
                int value_1 = 0;
                int value_2 = 0;
                Pair[] framePairs = new Pair[featureNum];
                
                for (int k = 0; k < featureNum; k++) {
                    
                        framePairs[k] = feature.new Pair(sc.nextInt(), sc.nextInt());

                }
                
                arr.add(framePairs);
            } 
            getMaxFeature(arr);
        } 
    }

    public static int getMaxFeature(ArrayList<Pair[]> arr) {
        
        int max = 1;
        
        HashMap<Pair, Integer> lastMap = new HashMap<>();
        HashMap<Pair, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            currentMap = new HashMap<>();
            Pair[] feature = arr.get(i);
            for (int j = 0; j < feature.length; j++) {
                Pair currentPair = feature[j];
                if(lastMap.containsKey(currentPair)) {
                    
                    if(!currentMap.containsKey(currentPair)) {
                        currentMap.put(currentPair, 1+lastMap.get(currentPair));
                        if(max < 1+lastMap.get(currentPair))
                            max = 1+lastMap.get(currentPair);
                    }
                    else
                        continue;
                }
                else {
                    currentMap.put(currentPair, 1);
                }  
            }
            lastMap = currentMap;
        }
        System.out.println(max);
        return max;
    }
}