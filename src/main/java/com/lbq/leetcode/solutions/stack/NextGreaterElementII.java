package com.lbq.leetcode.solutions.stack;

import com.lbq.leetcode.solutions.array.ArrayUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode: 503. 下一个更大元素 II
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * @author linbingqiang
 * @since 2022/4/14 5:35 下午
 */
public class NextGreaterElementII {

    public static void main(String[] args) {
        NextGreaterElementII ngeii = new NextGreaterElementII();
        int[] nums = {1,2,3,4,3};
        int[] result = ngeii.nextGreaterElements(nums);
        ArrayUtils.printArray(result);
    }

    public int[] nextGreaterElements(int[] nums) {
        //如何处理循环数组
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int length = nums.length;
        for (int i = 1; i < 2 * length; i++) {
           if (nums[i % length] <= nums[stack.peek()]) {
               stack.push(i % length);
           } else {
               while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                   Integer index = stack.pop();
                   result[index] = nums[i % length];
               }
               stack.push(i % length);
           }
        }
        return result;
    }
}
