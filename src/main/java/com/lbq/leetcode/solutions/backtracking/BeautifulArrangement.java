package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode: 526. 优美的排列
 * https://leetcode-cn.com/problems/beautiful-arrangement/
 * @author linbingqiang
 * @since 2022/4/14 10:20 上午
 */
public class BeautifulArrangement {

    int count = 0;

    Deque<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        BeautifulArrangement ba = new BeautifulArrangement();
        ba.countArrangement(2);
        System.out.println(ba.count);
    }

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        backtracking(n, used, 0);
        return count;
    }

    public void backtracking(int n, boolean[] used, int startIndex) {
        //1. 递归终止条件
        if (path.size() == n) {
            if (isBeautiful(path)) {
                count++;
            }
            return;
        }
        //2. 遍历
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(i);
            used[i] = true;
            //递归
            backtracking(n, used, i + 1);
            //回溯
            path.removeLast();
            used[i] = false;
        }
    }

    public boolean isBeautiful(Deque<Integer> path) {
        List<Integer> list = new ArrayList<>(path);
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i) % (i + 1) ;
            int b = (i + 1) % list.get(i);
            if (a != 0 && b != 0) {
                return false;
            }
        }
        return true;
    }
}
