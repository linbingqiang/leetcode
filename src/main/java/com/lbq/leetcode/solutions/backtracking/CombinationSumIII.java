package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和III
 * @author linbingqiang
 * @since 2022/3/5 9:12 下午
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        combinationSumIII.backtracking(3, 7, 1, 0);
        System.out.println(combinationSumIII.result);
    }

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSumIII(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    /**
     *
     * @param k 目标数量
     * @param n 目标数量总和
     * @param startIndex 开始下标
     * @param pathSum 当前已经访问过的数据的总和
     */
    public void backtracking(int k, int n, int startIndex, int pathSum) {
        if (pathSum > n) {
            // 剪枝操作
            return;
        }
        //终止条件 路径长度等于k且路径和等于n
        if (path.size() == k && pathSum == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.addLast(i);
            pathSum += i;
            backtracking(k, n, i + 1, pathSum);
            path.removeLast();
            pathSum -= i;
        }
    }
}
