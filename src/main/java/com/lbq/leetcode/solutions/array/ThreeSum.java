package com.lbq.leetcode.solutions.array;

import java.util.*;

/**
 * LeetCode:15
 * 三数之和
 * @author linbingqiang
 * @since 2022/3/7 10:33 下午
 */
public class ThreeSum {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    int sum = 0;
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum ts = new ThreeSum();
        Arrays.sort(nums);
        ts.threeSum(nums);
        System.out.println(ts.result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used,0, sum);
        return result;
    }

    public void backtracking(int[] nums, boolean[] used, int startIndex, int sum) {
        //判断终止条件
        if (path.size() == 3 && sum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //单层处理逻辑
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            sum += nums[i];
            used[i] = true;
            //递归
            backtracking(nums, used,i + 1, sum);
            //回溯
            path.removeLast();
            sum -= nums[i];
            used[i] = false;
        }
    }

    public int getSum(Deque<Integer> path) {
        int sum = 0;
        for (Integer integer : path) {
            sum += integer;
        }
        return sum;
    }
}
