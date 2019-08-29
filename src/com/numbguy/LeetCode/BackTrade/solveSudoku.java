package com.numbguy.LeetCode.BackTrade;

public class solveSudoku {
    /***
     * solution_1
     * @param board
     */
    public static void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public static boolean helper(char[][] board, int row, int column) {
        if(row == 9)
            return true;

        if(column == 9)
            return helper(board, row+1, 0);

        if(board[row][column] == '.') {
            for(int i = 1;i <= 9;i++) {
                board[row][column] = (char)(i+'0');
                if(isValid(board, row, column)) {
                   if(helper(board, row, column + 1))
                       return true;
                }
            }
            board[row][column] = '.';
        }else{
            return helper(board, row, column + 1);
        }
        return false;
    }

    public static boolean isValid(char[][] board, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if(i!=column&&board[row][i]==board[row][column])
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if(i!=row&&board[i][column]==board[row][column])
                return false;
        }
        for(int i = row/3*3;i < row/3*3+3;i++)
            for (int j = column/3*3; j < column/3*3+3; j++) {
                if((i!=row||j!=column)&&board[row][column]==board[i][j])
                    return false;
            }
        return true;
    }


    /***
     * ***
     * solution_2
     * @param board
     */

    public static void solveSudoku_solution_2(char[][] board) {
        /*
        rowValid[i][j]表示i行(j+1)数字是否已存在
        columnValid[i][j]表示i列（j+1）数字是否已存在
        blockValid[i][j]表示第（i/3*3+j/3）个九格宫（从上至下，从左至右）中(j+1)数字是否已存在
         */

        boolean rowValid[][] = new boolean[9][9];
        boolean columnValid[][] = new boolean[9][9];
        boolean blockValid[][] = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    continue;

                rowValid[i][board[i][j] - '1'] = true;
                columnValid[j][board[i][j] - '1'] = true;
                blockValid[i/3*3+j/3][board[i][j] - '1'] = true;
            }
        }
        dfs(board, rowValid, columnValid, blockValid, 0,0);
    }

    public static boolean dfs(char[][] board, boolean[][] rowValid, boolean[][] columnValid, boolean[][] blockValid,
                           int row, int column) {

        if(row == 9)
            return true;

        if(column == 9)
            return dfs(board, rowValid, columnValid, blockValid, row+1, 0);
        if(board[row][column] == '.') {
            for(int i = 0;i < 9;i++) {
                if(rowValid[row][i]||columnValid[column][i]||blockValid[row/3*3+column/3][i])
                    continue;

                board[row][column] = (char)(i+'1');
                rowValid[row][i] = true;
                columnValid[column][i] = true;
                blockValid[row/3*3+column/3][i] = true;

                if(dfs(board, rowValid, columnValid, blockValid, row, column+1))
                    return true;
                board[row][column] = '.';
                rowValid[row][i] = false;
                columnValid[column][i] = false;
                blockValid[row/3*3+column/3][i] = false;
            }
            return false;
        }

        return dfs(board, rowValid, columnValid, blockValid, row, column+1);
    }



    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'5', '3','.','.','7','.','.','.','.'},
                {'6', '.','.','1','9','5','.','.','.'},
                {'.', '9','8','.','.','.','.','6','.'},
                {'8', '.','.','.','6','.','.','.','3'},
                {'4', '.','.','8','.','3','.','.','1'},
                {'7', '.','.','.','2','.','.','.','6'},
                {'.', '6','.','.','.','.','2','8','.'},
                {'.', '.','.','4','1','9','.','.','5'},
                {'.', '.','.','.','8','.','.','7','9'},
        };

        //solveSudoku(board);
        solveSudoku_solution_2(board);
        printBoard(board);
    }
}
