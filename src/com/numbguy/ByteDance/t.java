package com.numbguy.ByteDance;

import java.util.Scanner;

public class t {
    static int min_dis = Integer.MAX_VALUE;
    static int min_probably_index  = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityNum = sc.nextInt();
        int[][] dis = new int[cityNum][cityNum];
        boolean[] visited = new boolean[cityNum];
        
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < cityNum; i++) {
            for (int j = 0; j < cityNum; j++) {
                dis[i][j] = sc.nextInt();  
                if(i ==0&&temp>dis[i][j]) {
                    temp = dis[i][j];
                    min_probably_index = j;

                }
            }
            
        }
        visited[0] = true;
        backTrace(cityNum, dis, 1, 0, visited, 0);   
        System.out.println(min_dis);
    }
    public static void backTrace(int n, int[][] dis, int index,int curretn_city, boolean[] visited,
                         int current_length) {
        if(index == n) {
            int min = current_length + dis[curretn_city][0];
            if(min < min_dis) min_dis = min;
        }else {
            for (int i = 0; i < n; i++) {
                int real_index = (i+min_probably_index)%n;
                if(!visited[real_index]&&(min_dis > current_length+dis[curretn_city][real_index])) {
                    visited[real_index]  = true;
                    current_length += dis[curretn_city][real_index];
                    backTrace(n, dis, index+1, real_index, visited, current_length);
                    current_length -= dis[curretn_city][real_index];
                    visited[real_index] = false;
                }
            }
        }
    }    
}