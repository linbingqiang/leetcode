package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode: 1161. 最大层内元素和
 * https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/
 *               1
 *             /   \
 *            7     0
 *          /   \
 *         7     -8
 * 解题思路：层序遍历
 *
 * @author linbingqiang
 * @since 2022/3/30 7:52 上午
 **/
public class MaximumLevelSumOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(0);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(-8);
        node1.left = node3;
        node1.right = node4;

        MaximumLevelSumOfBinaryTree mlsbt = new MaximumLevelSumOfBinaryTree();
        System.out.println(mlsbt.maxLevelSum(root));
    }

    public int maxLevelSum(TreeNode root) {
        //特殊case
        if (root == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //每层的最大值，初始值为root.val
        int maxSum = root.val;
        int maxLevel = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
