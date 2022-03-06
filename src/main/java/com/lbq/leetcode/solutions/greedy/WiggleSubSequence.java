package com.lbq.leetcode.solutions.greedy;

/**
 * LeetCode:376
 * 摆动序列
 * [1, 17, 5, 10, 13, 15, 10, 5, 16, 8]
 *
 * i = 0，currDiff = 16
 * i = 1, currDiff = -12
 * i = 2, currDiff = 5
 * i = 3, currDiff = 3
 * i = 4, currDiff = 2
 * i = 5, currDiff = -5
 * i = 6, currDiff = 11
 * i = 7, currDiff = -8
 * @author linbingqiang
 * @since 2022/3/6 10:03 下午
 */
public class WiggleSubSequence {

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        WiggleSubSequence wss = new WiggleSubSequence();
        System.out.println(wss.wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int currDiff = 0;
        int preDiff = 0;
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
