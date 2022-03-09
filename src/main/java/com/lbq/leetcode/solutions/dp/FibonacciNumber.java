package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode:509
 * 斐波那契数列
 * @author linbingqiang
 * @since 2022/3/9 9:18 上午
 **/
public class FibonacciNumber {

    public static void main(String[] args) {
        FibonacciNumber fn = new FibonacciNumber();
        System.out.println(fn.fin1(10));
    }

    public int fib(int n) {
        //1. 确定dp数组及其下标的含义: dp[j]表示第j个数的斐波那契数值
        int[] dp = new int[n + 1];
        //2. 确定递推公式: dp[j] = dp[j - 1] + dp[j - 2]
        //3. dp数组如何初始化
        dp[0] = 0; dp[1] = 1;
        //4. 确定遍历顺序：从左向右遍历
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //5. 举例，打印dp数组
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + ",");
        }
        System.out.println();
        return dp[n];
    }

    /**
     * 优化
     */
    public int fin1(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
