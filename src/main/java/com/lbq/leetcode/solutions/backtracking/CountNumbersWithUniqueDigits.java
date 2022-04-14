package com.lbq.leetcode.solutions.backtracking;

import java.util.*;

/**
 * LeetCode: 357. 统计各位数字都不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * @author linbingqiang
 * @since 2022/4/14 11:03 下午
 */
public class CountNumbersWithUniqueDigits {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    int count = 1;


    public static void main(String[] args) {
        CountNumbersWithUniqueDigits cnwud = new CountNumbersWithUniqueDigits();
        System.out.println(cnwud.countNumbersWithUniqueDigits(8));
        System.out.println(cnwud.result);
//        System.out.println(cnwud.countNumbersWithUniqueDigits(1));
//        System.out.println(cnwud.countNumbersWithUniqueDigits(2));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        backtracking(n);
        return count;
    }

    public void backtracking(int n) {
        //判断终止条件
        if (path.size() > n) {
            return;
        }
        //判断当前路径path中的数据是否满足条件
        if (!path.isEmpty() && valid(path)) {
//            result.add(new ArrayList<>(path));
            count++;
        }
        for (int i = 0; i <= 9; i++) {
            path.addLast(i);
            backtracking(n);
            path.removeLast();
        }
    }

    public boolean valid(Deque<Integer> path) {
        Set<Integer> pathSet = new HashSet<>(path);
        return !path.isEmpty() && path.peek() != 0 && path.size() == pathSet.size();
    }

}
