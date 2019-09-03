package com.numbguy.ByteDance;

import java.util.Scanner;

import sun.swing.BakedArrayList;

/*
链接：https://www.nowcoder.com/questionTerminal/3d1adf0f16474c90b27a9954b71d125d
来源：牛客网

小明目前在做一份毕业旅行的规划。打算从北京出发，分别去若干个城市，然后再回到北京，每个城市之间均乘坐高铁，且每个城市只去一次。由于经费有限，希望能够通过合理的路线安排尽可能的省一些路上的花销。给定一组城市和每对城市之间的火车票的价钱，找到每个城市只访问一次并返回起点的最小车费花销。

输入描述:
城市个数n（1<n≤20，包括北京）

城市间的车票价钱 n行n列的矩阵 m[n][n]


输出描述:
最小车费花销 s
示例1
输入
4
0 2 6 5
2 0 4 4
6 4 0 2
5 4 2 0
输出
13
*/

public class tsp {
    private static int min_dis;
    //public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // int cityNum = sc.nextInt();
        // int[][] dis = new int[cityNum][cityNum];
        // boolean[] visited = new boolean[cityNum];
        // int min_length = Integer.MAX_VALUE;
        // int current_length = 0;
        // for (int i = 0; i < cityNum; i++) {
        //     for (int j = 0; j < cityNum; j++) {
        //         dis[i][j] = sc.nextInt();
        //     }
        //}

        // int[][] dis = {{0, 2, 6, 5},
        //     {2, 0, 4, 4},
        //     {6, 4, 0, 2},
        //     {5, 4, 2, 0}};
            //boolean[] visited = new boolean[4];
            //System.out.println(min_dis);
            //backTrace(4, dis, 0, visited, 0);    
            //System.out.println(min_dis);
    //}
            public static void main(String[] args) {
                System.out.println("tsp");
            }
    public static void backTrace(int n, int[][] dis, int index, boolean[] visited,
                         int current_length) {
        if(index == n) {
            min_dis = current_length + dis[index-1][0];
        }else {
            for (int i = 0; i < n; i++) {
                if(!visited[i]&&(min_dis >= current_length+dis[inde][i])) {
                    visited[i]  = true;
                    current_length += dis[inde][i];
                    backTrace(n, dis, index+1, visited, current_length);
                    current_length -= dis[inde][i];
                    visited[i] = false;
                }
            }

        }
    }
}