package com.numbguy.ByteDance;

import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = 1024 - sc.nextInt();
        int count = 0;
        if((price/64)>0) { count += price/64; price %=64; }
        if((price/16)>0) { count += price/16; price %=16;}
        if((price/4)>0) { count += price/4; price %=4;}
        count += price;
        System.out.println(count);
        
    }  
}