package com.lbq.leetcode.solutions.dp;

/**
 * 0-1背包问题
 * @author linbingqiang
 * @since 2022/3/11 8:16 上午
 **/
public class WeightBagProblem {


    public static void main(String[] args) {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagWeight = 4;
        WeightBagProblem wb = new WeightBagProblem();
        int maxValue = wb.getMaxValue(weights, values, bagWeight);
        System.out.println();
        System.out.println(maxValue);
    }

    /**
     * 二维动态规划
     * 0-1背包问题
     * 背包容量为4
     * weights = {1, 3, 4}
     * values = {15, 20, 30}
     * dp[i][j]
     *        0   1    2    3    4
     * 物品0： 0   15   15   15   15
     * 物品1： 0
     * 物品2： 0
     * @param weights 物品的重量
     * @param values 物品的价值
     * @param bagWeight 背包最大容量
     * @return 获取背包最大重量范围内所容纳的物品的最大价值
     */
    public int getMaxValue(int[] weights, int[] values, int bagWeight) {
        //1. 确定dp数组及其下标的含义
        //dp[i][j] 表示从物品下标为0 - i的任意选取，放入容量为j的背包，价值总和最大
        int[][] dp = new int[weights.length][bagWeight + 1];
        //2. 确定递推公式. dp[i][j]其实可以由两个方向推导而来
        //2.1: dp[i][j] = dp[i - 1][j]，即背包容量为j，里面不放物品i的最大价值
        //2.2: dp[i][j] = dp[i - 1][j - weight[i]] + value[i]。表示背包容量为j - weight[i]时不放物品i的最大价值。此时取物品i，需要
        //     再加上物品i的价值，就是背包的最大价值。
        //综上，递推公式为：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
        //3. 确定dp数组的初始化顺序
        //3.1 当背包容量为j = 0时，此时不管取任何物品，总价值均为0，dp数组默认均为0
        //3.2 当背包容量j != 0时，需要判断weight[0]和背包容量的大小关系。
        for (int j = 1; j <= bagWeight; j++) {
            if (weights[0] <= bagWeight) {
                dp[0][j] = values[0];
            } else {
                dp[0][j] = 0;
            }
        }

        //4. 确定遍历顺序: 先遍历物品，再遍历背包
        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        //5. 打印dp数组
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        return dp[weights.length - 1][bagWeight];
    }
}
