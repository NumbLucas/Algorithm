package com.numbguy.base;

public class NumStringTransform {
    static final char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public static String numToHexIncludeLeadingZero(int num) {
        int leadingZeroNum = numberOfLeadingZeros(num)/4;
        StringBuilder s = new StringBuilder();
        while((leadingZeroNum--)>0) {
            s.append("0");
        }
        return s.append(toUnsignedInt(num, 4)).toString();
    }

    public static String numTBinaryxIncludeLeadingZero(int num) {
        int leadingZeroNum = numberOfLeadingZeros(num);
        StringBuilder s = new StringBuilder();
        while((leadingZeroNum--)>0) {
            s.append("0");
        }
        return s.append(toUnsignedInt(num, 1)).toString();
    }

    //以几位做偏移，比如二进制为1，8进制为3，16进制为4
    public static String toUnsignedInt(int num, int shift) {
        int binChars = 32 - numberOfLeadingZeros(num);
        int chars = (binChars%shift == 0)?(binChars/shift):(binChars/shift+1);
        if(chars == 0)
            chars = 1;
        
        char[] rst = new char[chars];
        formatUnsignedInt(num, shift, rst, chars);
        return new String(rst);
    }
    //len:总的长度；
    static void formatUnsignedInt(int val, int shift, char[] buf, int len) {
        int radix = 1<<shift;//几进制
        int mask = radix - 1;
        int pos = len;
        while((len--)>0) {
            buf[--pos] = digits[val&mask];
            val>>>=shift;
        }
    }
    //Integer中的实现
    //数字二进制中前面共多少个0（int总共32位）
    public static int numberOfLeadingZeros(int i) {
        // HD, Count leading 0's
        if (i <= 0)
            return i == 0 ? 32 : 0;
        int n = 31;
        if (i >= 1 << 16) { n -= 16; i >>>= 16; }
        if (i >= 1 <<  8) { n -=  8; i >>>=  8; }
        if (i >= 1 <<  4) { n -=  4; i >>>=  4; }
        if (i >= 1 <<  2) { n -=  2; i >>>=  2; }
        return n - (i >>> 1);
    }

    public static String numToString(int num) {
        return String.valueOf(num);
    }

    public static String numToHex(int num) {
        return Integer.toHexString(num);
        
    }
    
    public static void main(String[] args) {
        //2147483647
        for (int i = 2147483300; i < 2147483647; i++) {
            String original = Integer.toBinaryString(i);
            String mine = numTBinaryxIncludeLeadingZero(i);
            
            if(!original.equals(mine)) {
                System.out.println("right mine: " + mine+ " original: "+ original);
            }
            
        }
        System.out.println("success");
    }
}