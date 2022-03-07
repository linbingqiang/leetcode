package com.lbq.leetcode.solutions.backtracking;

import java.util.*;

/**
 * 面试题08.08 有重复字符串的排列组合
 * 1. 字符串都是英文字母
 * 2. 字符串长度在[1, 9]之间
 * @author linbingqiang
 * @since 2022/3/7 12:30 下午
 */
public class PermutationIILCCI {

    List<List<Character>> result = new ArrayList<>();

    Deque<Character> path = new LinkedList<>();

    public static void main(String[] args) {
        String S = "qqe";
        PermutationIILCCI p = new PermutationIILCCI();
        String[] res = p.permutation(S);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] used = new boolean[chars.length];
        // 对字符数组进行排序
        Arrays.sort(chars);
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
            if (i > 0 && chars[i] == chars[i -1] && !used[i - 1]) {
                // 当前字符等于前一个字符，并且前一个字符已经使用过，则跳过
                continue;
            }
            // 没有被使用过。如果去掉这个if，则可以解决某个元素重复选择的问题。
            if (!used[i]) {
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


}
