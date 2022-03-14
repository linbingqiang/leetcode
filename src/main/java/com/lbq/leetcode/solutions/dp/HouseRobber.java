package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode: 198
 * 打家劫舍
 * @author linbingqiang
 * @since 2022/3/14 10:33 下午
 */
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums = {1,2,3,1};
        System.out.println(hr.rob(nums));
        int[] nums1 = {2, 7, 9, 3, 1};
        System.out.println(hr.rob(nums1));
    }

    public int rob(int[] nums) {
        //1.确定dp数组及其下标的含义：dp[i]表示当抢劫到第i个房子时，获取到的最高金额
        int[] dp = new int[nums.length];
        //2.确定递推公式。对于第i个房子，可以选择抢或者不抢
        // 如果选择抢，则dp[i] = dp[i - 2] + nums[i]
        // 如果选择不抢，则dp[i] = dp[i - 1]
        // 所以，递推公式为：dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        //3. 确定初始化
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //4. 确定遍历顺序
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

