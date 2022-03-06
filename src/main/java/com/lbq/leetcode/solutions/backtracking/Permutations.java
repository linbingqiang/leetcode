package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode:46
 * 全排列问题
 * 排列是有序的，也就是[1, 2]和[2, 1]是两个集合。
 * 排列问题需要一个used数组，标记已经选择的元素。
 * @author linbingqiang
 * @since 2022/3/6 7:42 下午
 */
public class Permutations {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    public void backtracking(int[] nums, boolean[] used) {
        //1. 终止条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtracking(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result);
    }
}
