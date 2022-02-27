package com.lbq.leetcode.solutions.array;

/**
 * @author linbingqiang
 * @since 2022/2/27 8:45 下午
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,7,9,10};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(nums, 9));
    }

    /**
     * 二分法的使用条件：数组有序并且元素不重复
     * 注意区间。是左闭右闭区间还是左闭右开区间
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        //左闭右闭区间
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
}
