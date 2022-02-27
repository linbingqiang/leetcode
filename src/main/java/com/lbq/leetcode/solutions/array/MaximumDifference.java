package com.lbq.leetcode.solutions.array;

/**
 * LeetCode:2016
 * 增量元素之间的最大差值
 * @author linbingqiang
 * @since 2022/2/26 10:56 下午
 */
public class MaximumDifference {

    /**
     * 前缀最小值
     * 思路：
     * 当我们固定j时，选择的小标i一定是满足 0 <= i < j，并且nums[i]是最小的那个i。因此，我们可以使用循环对j进行遍历，同时
     * 维护nums[o...j]的前缀最小值，即为premin.
     * @param nums
     * @return
     */
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int preMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > preMin) {
                ans = Math.max(ans, nums[i] - preMin);
            } else {
                preMin = nums[i];
            }
        }
        return ans;
    }
}
