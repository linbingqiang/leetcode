package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode:70
 * 爬楼梯
 * @author linbingqiang
 * @since 2022/3/9 11:13 下午
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(5));
    }

    public int climbStairs(int n) {
        //1. 确定dp数组及其下标的含义。即dp[i]表示爬到第i阶楼梯，有dp[i]种方法
        int[] dp = new int[n + 1];
        //2. 确定递推公式
        // dp[i]可以由两个方向推出来。即：dp[i-1]，上 i - 1层楼梯，有dp[i - 1]种方法，那再跳一步台阶就是dp[i]
        // dp[i - 2]，上 i - 2层楼梯，有dp[i -2]种方法，再一步跳两个台阶就是dp[i]
        // 所以，递推公式dp[i] = dp[i - 1] + dp[i - 2]
        //3. dp数组如何初始化
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        //4. 遍历顺序 从左 -> 右遍历即可
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //5. 打印dp数组
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + ",");
        }
        System.out.println();
        return dp[n];
    }
}
