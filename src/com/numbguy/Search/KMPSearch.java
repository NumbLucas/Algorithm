package com.numbguy.Search;

import com.numbguy.Sort.Utils;

public class KMPSearch {
    public static void getNext(char[] data, int[] next) {
        int prefix = -1;
        int suffix = 0;
        next[0] = -1;
        while(suffix < data.length-1) {
            if(prefix == -1||data[prefix] == data[suffix]) {
                prefix++;
                suffix++;
                next[suffix] = prefix;
            }else {
                prefix = next[prefix];
            }
        }
    }
    public static int KMPSeatch(char[] str, char[] pattern) {
        int i = 0;
        int j = 0;

        int[] next = new int[pattern.length];
        getNext(pattern, next);

        while(i < str.length&&j<pattern.length) {
            if(j == -1||str[i] == pattern[j]) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }

        if(j == pattern.length) {
            return i-j;
        }
        return -1;
    }
    public static void main(String[] args) {
        String pattern = new String("bcabd");
        String str = new String("abcabcwnbaabcabdabdeq");
        int rst = KMPSeatch(str.toCharArray(), pattern.toCharArray());
        System.out.println(rst);
        //Utils.printArray(next);
    }
}
