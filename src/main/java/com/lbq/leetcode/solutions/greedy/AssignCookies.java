package com.lbq.leetcode.solutions.greedy;

import java.util.Arrays;

/**
 * LeetCode:455
 * 分发饼干
 * 解题思路
 * 1. 将两个数组分别从大到小进行排序
 * 2. 遍历小孩数组，看最大的饼干是否能够满足，如果能满足，则继续遍历；如果不满足，则小孩数组下标往小移动一位。
 * @author linbingqiang
 * @since 2022/3/6 9:40 下午
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int s[]) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            //如果当前index指定的饼干能够满足当前小孩的胃口
            if (index >= 0 && s[index] >= g[i]) {
                result++;
                index--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        AssignCookies ac = new AssignCookies();
        System.out.println(ac.findContentChildren(g, s));
    }
}
