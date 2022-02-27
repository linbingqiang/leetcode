package com.lbq.leetcode.solutions.array;

/**
 * LeetCode:27
 * 原地移除元素
 * @author linbingqiang
 * @since 2022/2/27 11:02 下午
 */
public class RemoveElements {

    public int removeElements(int[] nums, int target) {
        //暴力解法 时间复杂度为O(N^2)
//        int size = nums.length;
//        for (int i = 0; i < size; i++) {
//            if (nums[i] == target) {
//                for (int j = i + 1; j < size; i++) {
//                    nums[j - 1] = nums[j];
//                }
//                i--;
//                size--;
//            }
//        }
//        return size;

        //快慢指针
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != target) {
                nums[slow] = nums[fast];
                slow++;
            }  //do nothing

        }
        return slow;
    }
}
