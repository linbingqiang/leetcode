package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题08.07 无重复字符串的排列组合
 * 1. 字符串都是英文字母
 * 2. 字符串长度在[1, 9]之间
 * @author linbingqiang
 * @since 2022/3/7 12:30 下午
 */
public class PermutationIICCI {

    List<List<Character>> result = new ArrayList<>();

    Deque<Character> path = new LinkedList<>();

    public static void main(String[] args) {
        String S = "qwe";
        PermutationIICCI p = new PermutationIICCI();
        String[] res = p.permutation(S);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];
        backtracking(chars, used);
        System.out.println(result);
        // result转字符串数组
        String[] strings = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            List<Character> characters = result.get(i);
            StringBuilder sb = new StringBuilder();
            for (Character ch : characters) {
                sb.append(ch);
            }
            strings[i] = sb.toString();
        }
        return strings;
    }

    public void backtracking(char[] chars, boolean[] used) {
        //判断终止条件
        if (path.size() == chars.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(chars[i]);
            //递归
            backtracking(chars, used);
            //回溯
            used[i] = false;
            path.removeLast();
        }
    }


}
