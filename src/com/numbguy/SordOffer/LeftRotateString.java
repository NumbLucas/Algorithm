package com.numbguy.SordOffer;

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        int length = str.length();
        int step = 0;

        if(length < 1)
            return str;
        step = n%length;

        StringBuilder s = new StringBuilder();
        for(int i = step;i < step+length;i++) {
            //s.append()
        }

        return s.toString();
    }
}
