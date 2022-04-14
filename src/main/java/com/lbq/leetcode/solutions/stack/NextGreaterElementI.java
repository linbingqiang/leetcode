package com.lbq.leetcode.solutions.stack;

import com.lbq.leetcode.solutions.array.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode: 496. 下一个更大元素 I
 * @author linbingqiang
 * @since 2022/4/14 4:41 下午
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        NextGreaterElementI ngei = new NextGreaterElementI();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] result = ngei.nextGreaterElement(nums1, nums2);
        ArrayUtils.printArray(result);
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        /**
         * nums1是nums2的子集，nums1中的元素在nums2中肯定存在，nums1在nums2中的元素下标位置，可以通过Map的方式来存储
         * 所以，我们可以先求出nums2中的每个元素的下一个更大元素，然后再映射到nums1中
         */
        //返回结果集
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Map<Integer, Integer> num1Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            num1Map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    int value = nums2[stack.peek()];
                    stack.pop();
                    if (num1Map.containsKey(value)) {
                        int index = num1Map.get(value);
                        result[index] = nums2[i];
                    }
                }
                stack.push(i);
            }
        }
         // ArrayUtils.printArray(result);
        return result;
    }
}
