package com.lbq.leetcode.solutions.backtracking;

/**
 * @author linbingqiang
 * @since 2022/3/19 10:40 下午
 */
public class MovingCounts {

    public static void main(String[] args) {
        MovingCounts mc = new MovingCounts();
        System.out.println(mc.movingCount(2, 3, 0));
        System.out.println(mc.movingCount(2, 3, 1));
        System.out.println(mc.movingCount(2, 3, 2));
        System.out.println(mc.movingCount(2, 3, 3));
    }

    public int movingCount(int m, int n, int k) {
        //创建方格，默认值都为0
        int[][] board = new int[m][n];
        return dfs(board, m, n, 0, 0, k);
    }

    public int dfs(int[][] board, int m, int n, int i, int j, int k) {
        //判断是否出边界
        if (i >= m || j >= n || board[i][j] == 1) {
            return 0;
        }
        //计算下标i和j的数位之和
        int sum = sum(i) + sum(j);
        if (sum > k) {
            return 0;
        }
        board[i][j] = 1;
        return dfs(board, m, n, i + 1, j, k) + dfs(board, m, n, i, j + 1, k) + 1;
    }

    public int sum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
