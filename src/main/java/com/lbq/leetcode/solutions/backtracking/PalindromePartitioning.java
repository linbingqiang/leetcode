package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode:131
 * 分割回文串
 * 1. 切割问题
 * 2. 如何判断一个字符串是回文串
 * @author linbingqiang
 * @since 2022/3/6 1:31 下午
 */
public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();
    Deque<String> path = new LinkedList<>();


    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
        //判断终止条件
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String subStr = s.substring(startIndex, i + 1);
                path.addLast(subStr);
                backtracking(s, i + 1);
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j ; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaba";
        PalindromePartitioning pp = new PalindromePartitioning();
        pp.backtracking(s, 0);
        System.out.println(pp.result);
    }
}
