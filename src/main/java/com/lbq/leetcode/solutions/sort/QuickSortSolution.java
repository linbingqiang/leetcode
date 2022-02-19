package com.lbq.leetcode.solutions.sort;

public class QuickSortSolution {

    public static void main(String[] args) {
        int[] nums = {3, 4, 6, 5, 3, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(nums, low, high);
        quickSort(nums, low, partition - 1);
        quickSort(nums, partition + 1, high);
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[high] = pivot;
        return high;
    }
}
