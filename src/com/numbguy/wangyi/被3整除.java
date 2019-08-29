package com.numbguy.wangyi;

import java.util.Scanner;

/*
题目描述
小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。

并且小Q对于能否被3整除这个性质很感兴趣。

小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。

输入描述:
输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
输出描述:
输出一个整数, 表示区间内能被3整除的数字个数
示例1
输入
2 5

输出
3

说明
12, 123, 1234, 12345...
其中12, 123, 12345能被3整除。
 */
public class 被3整除 {

    public static int solution(int left, int right){
        int rst = 0;

        int num = right - left + 1;
        while((num--)>0) {
            int i = right--;
            int value = 0;
            int length = 0;
            while(i>0) {
                length += getLength(i);
                value += i*Math.pow(10, length-1);
                i--;
            }
            if(0 == (value%3)) {
                rst++;
            }
        }
        return rst;
    }

    public static int getLength(int i) {
        int length = 0;

        while(i>0) {
            i = i/10;
            length++;
        }
        return length;
    }

    public static int solution_2(int left, int right){
        int rst = 0;
        for(int i = left;i < right;i++) {
            int length = i;

            StringBuilder s = new StringBuilder("");
            while(length>0) {
                s.append(Integer.toString(i-length+1));

                length--;
            }

            if(Integer.parseInt(s.toString())%3 == 0)
                rst++;
        }
        return rst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int rst = 0;
            for(int i = left;i <= right;i++) {
                if(i%3 == 0||
                        i%3 == 2) {
                    rst++;
                }
            }
            System.out.println(rst);
        }
    }
}
