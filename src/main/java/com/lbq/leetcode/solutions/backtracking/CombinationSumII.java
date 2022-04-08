package com.lbq.leetcode.solutions.backtracking;


import java.util.*;

/**
 * LeetCode:40  组合总和II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次 。
 * 注意：解集不能包含重复的组合。 
 * candidates = [2,5,2,1,2], target = 5
 * [
 * [1,2,2],
 * [5]
 * ]
 * @author linbingqiang
 * @since 2022/3/6 1:21 下午
 */
public class CombinationSumII {

    private List<List<Integer>> result = new ArrayList<>();

    private Deque<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        CombinationSumII sumII = new CombinationSumII();
        int[] candidates = {2, 5, 2, 1, 2};
        sumII.combinationSum2(candidates, 5);
        System.out.println(sumII.result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, used, target, 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, boolean[] used, int target, int sum, int startIndex) {
        //1. 终止条件
        if (sum > target) {
            return;
        }
        if (sum == target) {
            //收集结果集
            result.add(new ArrayList(path));
            return;
        }
        //2. 循环处理
        for (int i = startIndex; i < candidates.length; i++) {
            //去重处理
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.addLast(candidates[i]);
            sum += candidates[i];
            //递归
            backtracking(candidates, used, target, sum, i + 1);
            //回溯
            used[i] = false;
            path.removeLast();
            sum -= candidates[i];
        }
    }

}
