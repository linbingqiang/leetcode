package com.lbq.leetcode.solutions.array;

/**
 * LeetCode:209
 * 长度最小的子数组
 * @author linbingqiang
 * @since 2022/4/12 8:49 上午
 **/
public class MinimumSizeSubArrayNum {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        MinimumSizeSubArrayNum mssan = new MinimumSizeSubArrayNum();
        System.out.println(mssan.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                int length = j - i + 1;
                sum -= nums[i];
                i = i + 1;
                minLength = Math.min(minLength, length);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
