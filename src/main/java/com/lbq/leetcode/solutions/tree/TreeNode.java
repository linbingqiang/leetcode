package com.lbq.leetcode.solutions.tree;

/**
 * 节点定义
 * @author linbingqiang
 * @since 2022/2/19 10:46 上午
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
