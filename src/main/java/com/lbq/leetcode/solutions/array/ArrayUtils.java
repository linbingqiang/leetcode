package com.lbq.leetcode.solutions.array;

/**
 * @author linbingqiang
 * @since 2022/2/27 9:47 下午
 */
public class ArrayUtils {

    public static void printArray(int[] nums) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(",");
        }
        int index = sb.lastIndexOf(",");
        sb.deleteCharAt(index);
        sb.append("]");
        System.out.println(sb.toString());
    }
}
