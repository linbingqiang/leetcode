package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode:51
 * N皇后
 * @author linbingqiang
 * @since 2022/3/6 8:39 下午
 */
public class NQueens {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] chessboard = new String[n][n];
        //初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = ".";
            }
        }
        backtracking(chessboard, n, 0);
        return result;
    }

    public void backtracking(String[][] chessboard, int n, int row) {
        // 终止条件
        if (row == n) {
            //将当前棋盘的摆放结果放入结果集中
            result.add(convertToList(chessboard, n));
            return;
        }

        //单层处理逻辑
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, chessboard, n)) {
                chessboard[row][col] = "Q";
                //递归
                backtracking(chessboard, n, row + 1);
                //回溯
                chessboard[row][col] = ".";
            }
        }
    }

    /**
     * 判断当前摆放是否有效
     * @param row 当前行
     * @param col 当前列
     * @param chessboard 棋盘
     * @param n 棋盘大小
     * @return true/false
     */
    public boolean isValid(int row, int col, String[][] chessboard, int n) {
        //检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col].equals("Q")) {
                return false;
            }
        }

        //检查45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j].equals("Q")) {
                return false;
            }
        }

        //检查135度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public List<String> convertToList(String[][] chessboard, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(chessboard[i][j]);
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens(4);
        System.out.println(result);
    }
}
