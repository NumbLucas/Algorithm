package com.numbguy.LeetCode.BackTrade;

public class hasPath {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(rows<1||cols<1||str.length == 0)
            return false;

        for(int i = 0; i < rows;i++)
            for(int j = 0; j < cols;j++)
                if(dfs(matrix, rows, rows,i, j, new boolean[rows*cols], 0, str))
                    return true;
        return false;
    }

    public static boolean dfs(char[] matrix, int rows, int cols, int x, int y, boolean[] flag, int k, char[] pattern) {


        int index = x*cols+y;

        if(!(x>=0&&x<rows&&y>=0&&y<cols)||
                flag[index]||
                matrix[index]!= pattern[k])
            return false;

        if(k == pattern.length - 1)
            return true;
        flag[index] = true;
        if(dfs(matrix, rows, cols, x, y+1, flag, k+1, pattern)||
                dfs(matrix, rows, cols, x, y-1, flag, k+1, pattern)||
                dfs(matrix, rows, cols, x-1, y, flag, k+1, pattern)||
                dfs(matrix, rows, cols, x+1, y, flag, k+1, pattern))
            return true;

        flag[index] = false;
        return false;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        String pattern = "adeb";

        System.out.println(hasPath(s.toCharArray(), 2, 3, pattern.toCharArray()));

    }
}
