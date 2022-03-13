package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode:494 目标和
 * 解题思路
 * 1. 回溯法
 * 2. 动态规划
 * @author linbingqiang
 * @since 2022/3/13 10:06 下午
 */
public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        TargetSum ts = new TargetSum();
        System.out.println(ts.findTargetSumWays(nums, target));
    }

    /**
     * 假设我们将数组分成两部分left和right，使得left - right = target
     * 同时，left + right = sum。此时，target和sum都是已知固定的。
     * 则left = (target + sum) / 2.
     * 所以此时问题就可以转化为在集合nums中找出和为left的组合。
     */

    public int findTargetSumWays(int[] nums, int target) {
        //1. 定义二维数组dp[i][j]，表示数组在nums的前i个数中选取元素，使得这些元素之和等于j的方案数。
        // 假设数组的nums的长度是n，则最终答案为dp[n][left]
        //2. 确定递推公式。
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length;
        int left = diff / 2;
        int[][] dp = new int[n + 1][left + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= left; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][left];
    }
}
