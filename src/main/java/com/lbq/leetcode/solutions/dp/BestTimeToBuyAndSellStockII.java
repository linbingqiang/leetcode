package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode:122
 * 买卖股票的最佳时机II
 * @author linbingqiang
 * @since 2022/3/15 10:51 下午
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStockII bs = new BestTimeToBuyAndSellStockII();
        System.out.println(bs.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        /**
         * dp[i][0]表示第i天持有股票所得现金
         * dp[i][1]表示第i天不持有股票所得最多现金
         * dp[i][0]可以由两个状态推导出来：
         * 1）第i-1天就持有股票，保持现状，所得现金就是昨天持有股票的所得现金，即dp[i][0] = dp[i - 1][0]
         * 2) 第i天持有股票，则持有股票的现金所得就是昨天不持有股票的所得现金减去今天的股票价格，即dp[i - 1][1] - prices[i]
         * dp[i][1]同样也可以由两个状态推导出来
         * 1）第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金，即dp[i - 1][1]
         * 2) 第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金：dp[i -  1][0] + prices[i]
         */
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }
}
