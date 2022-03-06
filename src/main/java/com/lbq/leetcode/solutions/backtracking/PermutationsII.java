package com.lbq.leetcode.solutions.backtracking;

import java.util.*;

/**
 * LeetCode:47
 * 全排列问题II
 * 包含重复数组的序列。按任意顺序，返回所有不重复的全排列。
 * nums=[1, 1, 2]
 * 输出：
 * [
 *  [1, 1, 2],
 *  [1, 2, 1],
 *  [2, 1, 1]
 * ]
 * 所以，理论上这个题的思路和全排列问题是一致的，只不过需要考虑的是怎么去重？
 * 两种方法：
 * 1. 返回全部集合结果只会进行去重操作
 * 2. 在回溯的时候就进行去重处理
 * @author linbingqiang
 * @since 2022/3/6 7:58 下午
 */
public class PermutationsII {

    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    public void backtracking(int[] nums, boolean[] used) {
        //判断终止条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //判断前一个元素是否已经被使用过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                //递归
                backtracking(nums, used);
                //回溯
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permutationsII.permuteUnique(nums);
        System.out.println(result);
    }
}
