package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode:213
 * 打家劫舍II
 * @author linbingqiang
 * @since 2022/3/14 10:48 下午
 */
public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        HouseRobberII hr2 = new HouseRobberII();
        System.out.println(hr2.rob(nums));
    }

    public int rob(int[] nums) {
        //解题思路：和198唯一的区别是，nums是成环的。针对成环，可以分成以下三种情况：
        //1. 选择抢劫的房屋不包括首尾房间 [1, 2, 3, 1]
        //                                ^  ^
        //2. 选择包含第一个房间，而不包含最后一个房间 [1, 2, 3 ,1]
        //                                       ^   ^  ^
        //3. 选择不包含第一个房间，而包含最后一个房间。[1, 2, 3, 1]
        //                                           ^  ^  ^
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int result1 = rob(nums, 0, n - 2);
        int result2 = rob(nums, 1, n - 1);
        return Math.max(result1, result2);
    }

    public int rob(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int n = right - left + 1;
        int[] dp = new int[n + 1];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[right];
    }
}
