package com.lbq.leetcode.solutions.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode: 300
 * 最长递增子序列
 * @author linbingqiang
 * @since 2022/3/16 11:01 下午
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lis.lengthOfLIS(nums));
        List<Integer> list = new ArrayList<>();

    }

    public int lengthOfLIS(int[] nums) {
        /**
         * 1. 明确dp数组及其下标的含义：
         * dp[i]表示下标i及其之前的最长递增子序列
         * 2. 明确递推公式：位置i的最长递增子序列是等于j从0 - （i - 1）各个位置的最长上升子序列 + 1
         * if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1)
         * 3. dp数组的初始化
         * 对应每个i，其最长递增子序列默认都是1
         * 4. 确定遍历顺序：从左到右
         */
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
