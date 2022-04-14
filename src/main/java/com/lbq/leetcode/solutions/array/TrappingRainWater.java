package com.lbq.leetcode.solutions.array;

/**
 * LeetCode：接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author linbingqiang
 * @since 2022/4/14 7:55 下午
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trw.twoPointer(height));
        System.out.println(trw.dp(height));
    }

    public int trap(int[] height) {
        return 0;
    }

    /**
     * 动态规划
     * @param height height
     * @return
     */
    public int dp(int[] height) {
        // 每个位置i能接的雨水数量等于Math.min(左侧最大值，右侧最大值) - height[i]
        // 可以求出每个位置i对应的左侧最大值数组leftMax和右侧最大值数组rightMax
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        //右侧最大值
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        //遍历
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int value = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (value > 0) {
                sum += value;
            }
        }
        return sum;
    }

    /**
     * 双指针解法
     * @param height height
     * @return
     */
    public int twoPointer(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            //对于当前位置i，搜索左边的最大值
            int leftHeight = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                leftHeight = Math.max(leftHeight, height[j]);
            }
            //对于当前位置i，搜索右边的最大值
            int rightHeight = Integer.MIN_VALUE;
            for (int k = i + 1; k < height.length; k++) {
                rightHeight = Math.max(rightHeight, height[k]);
            }
            // System.out.println("当前位置 i: " + i + " 左边最大值为：" + leftHeight + ", 右边最大值为：" + rightHeight);
            int minHeight = Math.min(leftHeight, rightHeight) - height[i];
            if (minHeight > 0) {
                sum += minHeight;
            }
        }
        return sum;
    }
}
