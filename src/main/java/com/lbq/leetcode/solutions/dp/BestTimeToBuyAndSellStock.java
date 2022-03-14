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
}
