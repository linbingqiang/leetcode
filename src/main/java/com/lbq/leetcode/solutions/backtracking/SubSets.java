package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode:78
 * 子集问题
 * 子集问题、组合问题和分割问题都可以抽象为一棵二叉树
 * 组合问题和分割问题都是收集树的叶子节，而子集问题时找树的所有节点
 * @author linbingqiang
 * @since 2022/3/6 6:46 下午
 */
public class SubSets {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> subSets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        //终止条件
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        SubSets ss = new SubSets();
        List<List<Integer>> result = ss.subSets(nums);
        System.out.println(result);
    }
}
