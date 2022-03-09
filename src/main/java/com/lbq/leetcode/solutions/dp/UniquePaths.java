package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode: 62
 * 不同路径
 * @author linbingqiang
 * @since 2022/3/9 11:40 下午
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        //1. 确定dp数组及其下标的含义。本题属于二维数组。dp[i][j]。表示机器人从左上角到达下标为(i, j)点时总共有多少不同的路径。
        int[][] dp = new int[m][n];
        //2. 确定递推公式。因为机器人只能向下或者向右移动，所以递推公式如下：
        // dp[i, j] = dp[i - 1][j] + dp[i][j - 1];
        //3. 确定dp数组如何初始化
        // dp[0][0] = 0;
        // 纵向角度，即dp[0][j]，路径数均为1。同理，横向角度dp[i][0]，路径数均为1
        dp[0][0] = 0;
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        //4. 确定遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
