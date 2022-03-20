package com.lbq.leetcode.solutions.array;

import java.util.Arrays;

/**
 * 剑指offer：21
 * 调整数组顺序使奇数位于偶数前面
 * @author linbingqiang
 * @since 2022/3/20 1:29 下午
 */
public class ExchangeArray {

    public static void main(String[] args) {
        ExchangeArray ea = new ExchangeArray();
        int[] nums = {1,2,3,4};
        int[] result = ea.exchange(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            // 当left为奇数，right为奇数
            if (isOdd(nums[left]) && isOdd(nums[right])) {
                left++;
            }
            // 当left为奇数，right为偶数
            else if (isOdd(nums[left]) && isEven(nums[right])) {
                left++;
                right--;
            }
            // 当left为偶数，right为奇数
            else if (isEven(nums[left]) && isOdd(nums[right])) {
                swap(nums, left, right);
                left++;
                right--;
            }
            // 当left为偶数，right为偶数
            else if (isEven(nums[left]) && isEven(nums[right])) {
                right--;
            }
        }
        return nums;
    }

    /**
     * 判断是否是奇数
     */
    public boolean isOdd(int num) {
        return num % 2 == 1;
    }

    /**
     * 判断是否是偶数
     */
    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    /**
     * 交换
     */
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
