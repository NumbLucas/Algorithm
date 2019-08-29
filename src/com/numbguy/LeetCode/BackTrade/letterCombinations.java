package com.numbguy.LeetCode.BackTrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinations {
    static HashMap<Character, String> map = new HashMap<>() {
        {
            put('0', "");
            put('1', "");
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> rst = new ArrayList<>();
        findCombination(digits, 0, "", rst);
        return rst;
    }

    public static  void findCombination(String digits, int index, String s, ArrayList<String> rst) {
        if(digits.length() == index){
            rst.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = map.get(c);
        for (int i = 0; i < letters.length(); i++) {

            findCombination(digits, index+1, s+letters.charAt(i), rst);
        }


    }

    public static void main(String[] args) {
        ArrayList<String> s = letterCombinations("5256");
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
}
