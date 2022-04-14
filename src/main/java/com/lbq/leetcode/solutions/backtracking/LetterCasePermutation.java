package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode:784. 字母大小写全排列
 * https://leetcode-cn.com/problems/letter-case-permutation/
 * @author linbingqiang
 * @since 2022/4/14 10:04 上午
 */
public class LetterCasePermutation {

    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public static void main(String[] args) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        lcp.letterCasePermutation("3z4");
        System.out.println(lcp.result);
    }

    public List<String> letterCasePermutation(String s) {
        dfs(s, 0);
        return result;
    }

    public void dfs(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(path.toString());
            return;
        }
        char ch = s.charAt(startIndex);
        if (Character.isLetter(ch)) {
            //如果是字母，可以选择转大小写或者不转
            char to = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
            path.append(to);
            //递归
            dfs(s, startIndex + 1);
            //回溯
            path.deleteCharAt(path.length() - 1);

        }
        path.append(ch);
        dfs(s, startIndex + 1);
        path.deleteCharAt(path.length() - 1);
    }
}
