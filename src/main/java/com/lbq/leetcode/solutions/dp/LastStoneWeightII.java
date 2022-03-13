package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode:1049
 * 最后一块石头的重量II
 * @author linbingqiang
 * @since 2022/3/11 11:44 下午
 */
public class LastStoneWeightII {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        LastStoneWeightII lsw2 = new LastStoneWeightII();
        System.out.println(lsw2.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = sum(stones);
        int target = sum / 2;
        //1. 确定dp数组及其下标的含义: dp[j]表示容量为j的背包，最多可以背dp[j]重量的石头
        int[] dp = new int[target + 1];
        //2. 确定递推公式 dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i])
        //3. 确定初始化
        //4. 确定遍历顺序
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }

    public int sum(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        return sum;
    }
}
