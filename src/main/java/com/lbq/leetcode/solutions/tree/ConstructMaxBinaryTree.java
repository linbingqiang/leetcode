package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:654
 * 构造最大的二叉树
 * @author linbingqiang
 * @since 2022/2/26 12:00 上午
 */
public class ConstructMaxBinaryTree {

    /**
     * 解题思路如下：
     * 1. 从数组中找到最大值及其下标位置
     * 2. 递归处理数组的左半部分和有半部分
     *  左闭右开的处理方式
     * @param nums 数组
     * @return TreeNode
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int maxValueIndex = findMax(nums, left, right);
        int rootVal = nums[maxValueIndex];
        TreeNode root = new TreeNode(rootVal);
        // 切割数组左半部分
        int leftBegin = left;
        int leftEnd = maxValueIndex;
        // 切割数组有半部分
        int rightBegin = maxValueIndex + 1;
        int rightEnd = right;
        root.left = constructMaximumBinaryTree(nums, leftBegin, leftEnd);
        root.right = constructMaximumBinaryTree(nums, rightBegin, rightEnd);
        return root;
    }

    /**
     * 在数组nums中，给定的范围[left, right]找到最大值的下表
     * @param nums nums
     * @param left 左半部分
     * @param right 右半部分
     * @return 最大值的下表
     */
    public int findMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = left; i < right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
