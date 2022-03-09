package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode:746
 * 使用最小花费爬楼梯
 * @author linbingqiang
 * @since 2022/3/9 11:26 下午
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(mccs.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        //1. 确定dp数组及下标的含义: dp[i]表示到达第i个台阶所花费的最少体力为dp[i]
        int[] dp = new int[cost.length];
        //2. 确定递推公式：dp[i]可以由两个方向递推过来，dp[i - 1] 和dp[i - 2]
        // 所以，递推公式应该是dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i]
        //3. 确定dp数组如何初始化
        dp[0] = cost[0];
        dp[1] = cost[1];
        //4. 确定遍历顺序
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        //5. 打印dp数组
        for (int i = 0; i < cost.length; i++) {
            System.out.print(dp[i] + ", ");
        }
        System.out.println();
        return dp[cost.length - 1];
    }

}
