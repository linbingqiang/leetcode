package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode: 123
 * 买卖股票的最佳时机III
 * @author linbingqiang
 * @since 2022/3/14 11:24 下午
 */
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStockIII bs = new BestTimeToBuyAndSellStockIII();
        System.out.println(bs.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        /**
         * 1. 确定dp数组及其下标的含义。一天一共就5个状态
         *      0: 没有操作
         *      1: 第一次买入
         *      2: 第一次卖出
         *      3: 第二次买入
         *      4: 第二次卖出
         * dp[i][j]表示第i天，状态为j[0 - 4]，dp[i][j]表示第i天状态为j所剩的最大现金
         * 2. 确定递推公式
         * dp[i][1]总共有两种状态：
         *  1）第i天买入股票，dp[i][1] = dp[i - 1][0] - prices[i]
         *  2) 第i天没有操作，dp[i][1] = dp[i - 1][1]
         *  所以:dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
         * dp[i][2]也有两种状态
         *  1）第i天卖出股票，dp[i][2] = dp[i - 1][1] + prices[i]
         *  2) 第i天没有操作，dp[i][2] = dp[i - 1][2]
         * 所以：dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i])
         * dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i])
         * dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i])
         * 3. 初始化
         * dp[0][0] = 0;
         * dp[0][1] = -prices[0];
         * dp[0][2] = 0;
         * dp[0][3] = -prices[0]
         * dp[0][4] = 0
         */
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[length - 1][4];
    }
}
