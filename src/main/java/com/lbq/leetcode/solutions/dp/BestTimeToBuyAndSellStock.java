package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode: 买卖股票的最佳时机
 * @author linbingqiang
 * @since 2022/3/14 11:24 下午
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStock bs = new BestTimeToBuyAndSellStock();
        System.out.println(bs.maxProfit(prices));
        System.out.println(bs.maxProfit1(prices));
        System.out.println(bs.maxProfitDp(prices));
    }


    public int maxProfit(int[] prices) {
        int result = 0;
        // 暴力解法
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result = Math.max(result, prices[j] - prices[i]);
            }
        }
        return result;
    }

    public int maxProfit1(int[] prices) {
        //贪心解法：每次取最小价格，最大价格的差值
        int low = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }

    public int maxProfitDp(int[] prices) {
        /**
         * 1. 确定dp数组的含义及其下标的含义
         *    dp[i][0]表示第i天持有股票所得的最高现金
         *    dp[i][1]表示第i天不持有股票所得的最高现金
         * 2. 确定递推公式
         *   对于dp[i][0]有两种情况：
         *   1) 当天不做任何操作，那么第i天所持有股票的最高现金就是第i-1天所持有股票的最高现金
         *   2) 当天进行股票买入操作，那么第i天所持有股票的最高现金就是第i-1天所持有股票的最高现金减去当天买入股票的价格
         *   综上所述：
         *   dp[i][0] = Math.max(dp[i - 1][0],  -prices[i])
         *   对于dp[i][1]同样也有两种情况:
         *   1) 当天不做任何操作，那么第i天所持有股票的最高现金就是保持现状，即dp[i][1] = dp[i - 1][1]
         *   2) 当天进行股票卖出操作，那么第i天所持有股票的最高现金就是dp[i - 1][0] + prices[i]
         *   综上所述：
         *   dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i])
         * 3. dp数组如何初始化
         *    dp[0][0] = -prices[0]
         *    dp[0][1] = 0
         * 4. 确定遍历顺序
         * 5. 打印dp数组
         */
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }
}
