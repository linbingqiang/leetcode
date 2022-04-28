package com.lbq.leetcode.solutions.array;

/**
 * @author linbingqiang
 * @since 2022/4/28 8:59 下午
 */
public class WiggleMaxLength {

    public static void main(String[] args) {
        int[] nums = {0, 0};
        WiggleMaxLength wml = new WiggleMaxLength();
        System.out.println(wml.wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int preDiff = 0;
        int currDiff = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            if ((currDiff > 0 && preDiff <= 0) || (currDiff < 0 && preDiff >= 0)) {
                result++;
                preDiff = currDiff;
            }
        }
        return result;
    }
}
