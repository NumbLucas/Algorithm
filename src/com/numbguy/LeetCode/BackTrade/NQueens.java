package com.numbguy.LeetCode.BackTrade;

import java.util.ArrayList;
/*
* n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
* 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NQueens {
    public static ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> rst = new ArrayList<>();
        helper(n, 0, new int[n], rst);
        return rst;
    }

    public static void helper(int n, int row, int[] queensPosForRow, ArrayList<ArrayList<String>> rst) {
        if(n == row) {
            ArrayList<String> s = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if(j == queensPosForRow[i])
                        tmp.append('Q');
                    else
                        tmp.append('.');
                }
                s.add(tmp.toString());
            }
            rst.add(s);
            return;
        }

        for(int i = 0;i < n; i++) {
            queensPosForRow[row] = i;
            if(isValid(row, queensPosForRow)) {
                helper(n, row + 1, queensPosForRow, rst);
            }
        }
    }

    public static boolean isValid(int row, int[] queensPosForRow) {
        for(int i = 0; i < row;i++) {
            if(queensPosForRow[i] == queensPosForRow[row] ||
                    Math.abs(queensPosForRow[i] - queensPosForRow[row]) == row - i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> s = solveNQueens(5);
        for (int i = 0; i < s.size(); i++) {
            System.out.println("solution_"+i);
            for(int j = 0;j < s.get(i).size();j++) {
                System.out.println(s.get(i).get(j));
            }
        }
    }
}
