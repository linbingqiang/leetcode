package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode:39
 * 组合总和
 * @author linbingqiang
 * @since 2022/3/5 10:09 下午
 */
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtracking(nums, target, 0, 0);
        return result;
    }

    public void backtracking(int[] nums, int target, int startIndex, int sum) {
        if (sum > target) {
            return;
        }
        //终止条件
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            sum += nums[i];
            path.addLast(nums[i]);
            backtracking(nums, target, i, sum);
            //回溯
            sum -= nums[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum cs = new CombinationSum();
        cs.combinationSum(candidates, target);
        System.out.println(cs.result);
    }
}
