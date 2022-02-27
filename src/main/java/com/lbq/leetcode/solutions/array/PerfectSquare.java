package com.lbq.leetcode.solutions.array;

/**
 * LeetCode：367
 * 有效的完全平方数
 * @author linbingqiang
 * @since 2022/2/27 10:54 下午
 */
public class PerfectSquare {

    public boolean isPerfectSquare(int num) {
        //二分法
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long temp = (long) mid * mid;
            if (temp == num) {
                return true;
            } else if (temp < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
