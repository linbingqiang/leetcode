package com.lbq.leetcode.solutions.dp;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * LeetCode:63
 * 不同路径II
 * @author linbingqiang
 * @since 2022/3/9 11:53 下午
 */
public class UniquePathsII {

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int [][] obstacleGrid = {
                {1, 0}
        };
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid));

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //1. 确定dp数组及其下标的含义。dp[i][j]表示从左上角开始到达(i, j)的不同路径数
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //2. 确定递推公式
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        //3. dp数组如何初始化
        // 当遍历最上面和最左边的时候，只要碰到一个有障碍的，后面的装填应该都是0
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        //4. 遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 有障碍，将其设置为0
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
