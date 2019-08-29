package com.numbguy;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) throws IOException {
        HashMap map = new HashMap<>();
        map.put(1, 2);
        map.put(1, 3);
    
        int[] array = {1, 3, 5, 7, 9};

        int index = Arrays.binarySearch(array, 6);

        String s = "1234";
        int i = -8;
        
        //System.out.println(i>>>=2);


        String path = "F:\\test\\test.txt";

//        File file = new File(path);
//        FileOutputStream fop = new FileOutputStream(file);
//        OutputStreamWriter osw = new OutputStreamWriter(fop);
//        osw.write("test");
//        osw.flush();


        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(path)));
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        char[] out = new char[10];
        int flag = 0;
//        while(isr.read(out) > 0) {
//
//            System.out.println(Integer.toString(++flag) + new String(out));
//        }
        while(true) {
            String buf = br.readLine();
            if(buf == null)
                break;
            System.out.println(buf);
        }


    }
}