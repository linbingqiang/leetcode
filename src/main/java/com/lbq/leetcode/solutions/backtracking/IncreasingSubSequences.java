package com.lbq.leetcode.solutions.backtracking;

import java.util.*;

/**
 * LeetCode:491
 * 递增子序列
 * @author linbingqiang
 * @since 2022/3/6 7:25 下午
 */
public class IncreasingSubSequences {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        //1. 终止条件
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        //2. 单层处理逻辑
        // 去重
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //判断当前元素是否大于前一个元素，如果小于，则跳过，不处理
            if ((!path.isEmpty() && nums[i] < path.peekLast())
                || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.addLast(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        IncreasingSubSequences iss = new IncreasingSubSequences();
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> result = iss.findSubsequences(nums);
        System.out.println(result);

    }

}
