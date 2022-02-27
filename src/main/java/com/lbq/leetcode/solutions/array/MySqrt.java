package com.lbq.leetcode.solutions.array;

/**
 * LeetCode:69
 * @author linbingqiang
 * @since 2022/2/27 10:29 下午
 */
public class MySqrt {

    /**
     * k^2 <= x。求k的最大值
     * 二分法
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
