package com.lbq.leetcode.solutions.backtracking;

/**
 * LeetCode:494
 * @author linbingqiang
 * @since 2022/3/5 9:55 下午
 */
public class FindTargetSumWays {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums, target, 0, 0);
        return count;
    }

    public void backtracking(int[] nums, int target, int index, int sum) {
        // 确定终止条件
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        backtracking(nums, target, index + 1, sum + nums[index]);
        backtracking(nums, target, index + 1, sum - nums[index]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        FindTargetSumWays ftsw = new FindTargetSumWays();
        System.out.println(ftsw.findTargetSumWays(nums, 3));
    }
}
