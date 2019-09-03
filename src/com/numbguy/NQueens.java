package com.numbguy;

public class NQueens {
    public static void main(String[] args) {
        
    }

    public void solution(int n) {

    }

    public boolean check(int n, int row, int[] queensPosForRow) {
        for (int i = 0; i < row; i++) {
            if(queensPosForRow[i] == queensPosForRow[row]||
                (row -i) == Math.abs(queensPosForRow[row] - queensPosForRow[i]) 
                return false;
        }
        return true;
    }

    public void dfs(int n, int row, int[] queensPosForRow) {
        if(n == row) {
            //TODO
            //output
        }
        for (int i = 0; i < n; i++) {
            queensPosForRow[row] = i;
            if(check(n, row, queensPosForRow))
                dfs(n, row+1, queensPosForRow);
        }
    }
}