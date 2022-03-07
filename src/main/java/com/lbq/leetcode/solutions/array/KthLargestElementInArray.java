package com.lbq.leetcode.solutions.array;

/**
 * LeetCode: 215
 * 数组中的第K个最大元素
 * @author linbingqiang
 * @since 2022/3/7 9:06 下午
 */
public class KthLargestElementInArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        KthLargestElementInArray kl = new KthLargestElementInArray();
        System.out.println(kl.findKthLargest(nums, 5));
    }

    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        return quickSelect(nums, 0, size - 1, size - k);
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        int pivot = partition(nums, left, right);
        if (pivot == index) {
            return nums[pivot];
        } else if (pivot < index){
            return quickSelect(nums, pivot + 1, right, index);
        } else {
            return quickSelect(nums, left, pivot - 1, index);
        }
    }

    /**
     * partition
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
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
