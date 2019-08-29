package com.numbguy.bihsi;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFind {

    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<int[]> int_map = new ArrayList<>();

    public static int findRoot(int x, int pre[]) {
        int r = x;

        while(pre[r]!=r) {
            r = pre[r];
        }

        int current = x;
        int j;
        while(pre[current]!=r) {
            j = pre[current];
            pre[current] = r;
            current = j;
        }

        return r;
    }

    public static int union(int x, int y, int[] pre) {
        int r_x = findRoot(x, pre);
        int r_y = findRoot(y, pre);

        if(r_x!=r_y)
            pre[r_y] = r_x;

        return r_x;
    }

    public static String[] split(String input) {
        String input_s = input.toString();
        String[] arr = input_s.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        return arr;
    }

    public static ArrayList<int[]> stringToIntArr(ArrayList<String> input) {
        int index = 0;

        for (int i = 0; i < input.size(); i++) {
            String[] arr = split(input.get(i));
            int[] int_arr = new int[arr.length];

            for(int j = 0;j< arr.length;j++) {
                if(map.containsKey(arr[i])){

                }else{
                    map.put(arr[j], index++);
                }
                int_arr[i] = map.get(arr[i]);
            }
        }

        return int_map;
    }

    public static int solution(String name, int groupNum, ArrayList<String> input){
        for (int i = 0; i < input.size(); i++) {
            stringToIntArr(input);
        }

        for(int i = 0;i < int_map.size();i++) {
            for (int j = 0; j < int_map.get(i).length-1; j++) {
                //int x = int_map.get(i)[j];
                //int y = int_map.get(i)[j+1];

            }

        }

        return 0;
    }
    public static void main(String[] args) {

    }
}
