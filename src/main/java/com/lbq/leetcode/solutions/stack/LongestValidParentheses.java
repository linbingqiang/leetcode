package com.lbq.leetcode.solutions.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * LeetCode: 32
 * 最长有效括号
 * @author linbingqiang
 * @since 2022/3/7 10:46 上午
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "()(()";
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        // 特殊case
        if (s == null || "".equals(s)) {
            return 0;
        }
        int maxCount = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                // 左括号 将对应的下标入栈
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxCount = Math.max(maxCount, i - stack.peek());
                }
            }
        }
        return maxCount;
    }
}
