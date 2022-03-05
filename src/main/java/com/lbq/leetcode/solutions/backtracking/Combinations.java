package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode:77
 * @author linbingqiang
 * @since 2022/3/5 8:53 下午
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations com = new Combinations();
        List<List<Integer>> result = com.combine(4, 2);
        System.out.println(result);
    }

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k){
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        //终止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 剪枝优化：剩余数组的数量要大于等于目标数量
        // n - (k - path.size()) + 1
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

}
