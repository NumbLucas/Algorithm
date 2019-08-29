package com.numbguy.wangyi;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;


public class t {
public static char solution(char currentToward, char nextTurn) {
        if((currentToward == 'W'&&nextTurn=='R')||
        (currentToward == 'E'&&nextTurn=='L')  ) {
        return 'N';
        }else if((currentToward == 'W'&&nextTurn=='L')||
        (currentToward == 'E'&&nextTurn=='R')) {
        return 'S';
        }else if((currentToward == 'N'&&nextTurn=='R')||
        (currentToward == 'S'&&nextTurn=='L')) {
        return 'E';
        }else if((currentToward == 'S'&&nextTurn=='R')||
        (currentToward == 'N'&&nextTurn=='L')) {
        return 'W';
        }
        return 'N';
}
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String length = br.readLine();
        String turn = br.readLine();

        char currentToward = 'N';
        //char nextTurn = turn.charAt(0);
        char rst = 'N';
        for(int i = 0;i<turn.length();i++) {
        rst = solution(rst,turn.charAt(i));
        }
        System.out.println(rst);
        }
}
