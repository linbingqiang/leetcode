package com.lbq.leetcode.solutions.stack;

import com.lbq.leetcode.solutions.array.ArrayUtils;

import java.util.Stack;

/**
 * LeetCode:739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author linbingqiang
 * @since 2022/4/14 4:13 下午
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temperatures = {30,40,50,60};
        int[] result = dt.dailyTemperatures(temperatures);
        ArrayUtils.printArray(result);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        //单调栈，存储元素的下标
        Stack<Integer> stack = new Stack<>();
        //将数组的第一个元素入栈
        stack.push(0);
        //遍历数组
        for (int i = 1; i < temperatures.length; i++) {
            //分三种情况
            //1. temperatures[i]小于栈顶元素，则将当前下标入栈
            if (temperatures[i] < temperatures[stack.peek()]) {
                stack.push(i);
            } else if (temperatures[i] == temperatures[stack.peek()]) {
                //2. temperatures[i] 等于栈顶元素
                stack.push(i);
            } else {
                //3. temperatures[i]大于栈顶元素，则需要将栈顶元素出栈，直到栈顶元素大于当前元素temperatures[i]
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer index = stack.pop();
                    //计算距离
                    result[index] = i - index;
                }
                //将当前元素入栈
                stack.push(i);
            }
        }
        return result;
    }


}
