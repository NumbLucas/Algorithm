package com.numbguy.ByteDance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jdk.jfr.Unsigned;

public class 万万没想到之抓捕孔连顺 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numInfo = br.readLine();
        String info[] = numInfo.split(" ");
        int pointNum = Integer.parseInt(info[0]);
        int maxDistance = Integer.parseInt(info[1]);
        String[] pos = br.readLine().split(" ");
        int[] pos_num = new int[pos.length];
        for(int i = 0;i < pos.length;i++) {
            pos_num[i] = Integer.parseInt(pos[i]);
        }
        
        
    }

}