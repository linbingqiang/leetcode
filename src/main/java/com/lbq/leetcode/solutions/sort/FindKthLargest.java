package com.lbq.leetcode.solutions.sort;


/**
 * LeetCode:215
 * 数组中的第K个最大元素
 * @author linbingqiang
 * @since 2022/2/22 11:22 下午
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest(nums, 2);
        System.out.println(result);
    }

    public static int findKthLargest(int[] nums, int k) {
        //快速选择排序
        int size = nums.length;
        return quickSelect(nums, 0, size - 1, size - k);
    }

    public static int quickSelect(int[] nums, int left, int right, int index) {
        //计算partition的位置
        int partition = partition(nums, left, right);
        if (partition == index) {
            return nums[partition];
        } else if (partition < index) {
            return quickSelect(nums, partition + 1, right, index);
        } else {
            return quickSelect(nums, left, partition - 1, index);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
