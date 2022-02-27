package com.lbq.leetcode.solutions.array;

/**
 * LeetCode:35
 * 搜索插入位置
 * 算法时间复杂度：O(lgN)
 * @author linbingqiang
 * @since 2022/2/27 9:00 下午
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        SearchInsert si = new SearchInsert();
        System.out.println(si.searchInsert(nums, 0));
        System.out.println(si.searchInsert(nums, 2));
        System.out.println(si.searchInsert(nums, 4));
        System.out.println(si.searchInsert(nums, 6));
        System.out.println(si.searchInsert(nums, 8));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //没搜到目标值
        return right + 1;
    }
}
