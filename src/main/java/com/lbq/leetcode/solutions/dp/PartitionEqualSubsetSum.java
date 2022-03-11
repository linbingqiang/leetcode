package com.lbq.leetcode.solutions.dp;

/**
 * LeetCode: 416
 * 分割等和子集
 * @author linbingqiang
 * @since 2022/3/11 11:14 下午
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
        int[] nums = {1, 2, 3, 5};
        System.out.println(pess.canPartitionByBacktracking(nums));
    }

    /**
     * 背包问题解决划分和相等的子集
     * 需要确定以下四点：
     * 1. 背包的体积为sum/2
     * 2. 背包要放入的商品（集合里的元素）重量为元素的数值，价值也为元素的数值
     * 3. 背包如果正好装满，说明找到了总和为sum/2的子集。
     * 4. 背包中每一个元素是不可以重复放入的。
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        //1. 确定dp数组及下标的含义：dp[i]表示背包总容量为i，最大可以凑成i的子集总和为dp[i]
        int[] dp = new int[10001];
        //2.确定递推公式：dp[i] = Math.max(dp[i], dp[i - nums[i]] + nums[i])
        //3.确定初始化顺序：先遍历物品，再遍历背包
        int sum = sum(nums);
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public boolean canPartitionByBacktracking(int[] nums) {
        int sum = sum(nums);
        // 能够划分为相等的两个子集，那么总和必然能够被2整除。
        if (sum % 2 == 1) {
            return false;
        }
        backtracking(nums, 0, sum / 2);
        return canPartition;
    }

    int totalSum = 0;
    boolean canPartition = false;
    public void backtracking(int[] nums, int startIndex, int halfSum) {
        if (totalSum == halfSum) {
            canPartition = true;
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            totalSum += nums[i];
            backtracking(nums, i + 1, halfSum);
            totalSum -= nums[i];
        }
    }

    public int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
