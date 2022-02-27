package com.lbq.leetcode.solutions.array;

/**
 * LeetCode:26
 * 删除有序数组中的重复项
 * @author linbingqiang
 * @since 2022/2/27 11:23 下午
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates rd = new RemoveDuplicates();
        int length = rd.removeDuplicates(nums);
        System.out.println(length);
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        //特殊case
        if (length == 0 || length == 1) {
            return length;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                // 找到第一个不等于slow的元素
                nums[slow + 1] = nums[fast];
                length--;
                slow = slow + 1;
            }
        }
        return slow + 1;
    }
}
