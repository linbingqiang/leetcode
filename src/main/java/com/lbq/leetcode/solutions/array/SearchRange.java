package com.lbq.leetcode.solutions.array;

/**
 * LeetCode:34
 * 在排序数组中查找元素的第一个和最后一个位置。要求时间复杂度为：O(lgN)
 * 分析如下：
 * 1. target在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或target为6，则应该返回{-1, -1};
 * 2. target在数组范围内，且数组中不存在target，例如数组{3, 6, 7}, target为5，则应该返回{-1, -1};
 * 3. target在数组范围内，且数组中存在target，例如数组{3, 6, 7},target为6，则应该返回{1, 1};
 * @author linbingqiang
 * @since 2022/2/27 9:35 下午
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        ArrayUtils.printArray(sr.searchRange(nums, 7));
        ArrayUtils.printArray(sr.searchRange(nums, 9));
        ArrayUtils.printArray(sr.searchRange(nums, 5));
        ArrayUtils.printArray(sr.searchRange(nums, 8));
        ArrayUtils.printArray(sr.searchRange(nums, 10));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
//        int lowerBound = lowerBound(nums, target);
//        int upperBound = upperBound(nums, target);
//        if (lowerBound == -2 && upperBound == -2) {
//            return new int[]{-1, -1};
//        }
//        if (upperBound - lowerBound > 1) {
//            return new int[]{lowerBound + 1, upperBound - 1};
//        }
//        return new int[]{-1, -1};
        int index = binarySearch(nums, target);
        if (index == -1) {
            return new int[] {-1, -1};
        }
        // nums中存在目标值，则左右滑动指针，找到符合的区间
        int left = index;
        int right = index;
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) {
            right++;
        }
        return new int[]{left, right};
    }


    public int binarySearch(int[] nums, int target) {
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
        return -1;
    }


    public int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int upperBound = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                upperBound = left;
            }
        }
        return upperBound;
    }

    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lowerBound = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                lowerBound = right;
            }
        }
        return lowerBound;
    }

}
