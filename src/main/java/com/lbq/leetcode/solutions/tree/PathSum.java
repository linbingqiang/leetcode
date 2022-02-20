package com.lbq.leetcode.solutions.tree;

import java.util.Stack;

/**
 * LeetCode:112
 * 二叉树的路径总和
 * 1. 递归处理（先序、中序和后序遍历都可以满足）
 *     递归判断条件是当前节点为叶子节点且从根节点到当前节点的路径总和等于目标值
 *     同时，需要注意的是当前节点不满足条件的时候，需要回溯。
 *     判断是否等于目标值有两种方法，一种是累加，一种是每次递减
 * 2. 迭代处理
 *                  5
 *                /   \
 *               4     8
 *             /      / \
 *            11     13  4
 *           / \          \
 *          7  2           1
 *  先序遍历过程如下
 *  stack: 5  pathSum:5   非叶子节点
 *  stack: 8,4  pathSum:5 + 8, 5 + 4   非叶子节点
 *
 *  弹出4
 *  stack:8  pathSum:5+8 非叶子节点
 *
 *  入栈：11
 *  stack:8, 11 pathSum:5 + 8, 5 + 4 + 11
 *
 *  出栈：11
 *  stack: 8, pathSum:5 + 8 非叶子节点
 *
 *  入栈：2, 7
 *  stack:8, 2, 7. pathSum:5 + 8; 5 + 4 + 11 + 2; 5 + 4 + 11 + 7
 *
 *  出栈：7, 5 + 4 + 11 + 7 叶子节点，但是路径和不等于target
 *  stack: 8, 2 pathSum: 5 + 8; 5 + 4 + 11 + 2;
 *
 *  出栈：2， pathSum = 5 + 4 + 11 + 2 = targetSum
 *  stack: 8 pathSum: 5 + 8
 *
 *  所以，返回true
 *
 *
 *
 * @author linbingqiang
 * @since 2022/2/20 7:28 下午
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        node3.left = node6;
        node3.left = node7;
        TreeNode node8 = new TreeNode(1);

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.traversalIter(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    public boolean traversalIter(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        //使用两个栈的方式：一个是nodeStack, 一个是pathSumStack
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> pathSumStack = new Stack<>();
        nodeStack.push(root);
        pathSumStack.push(root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer pathSum = pathSumStack.pop();
            //判断当前节点是否为叶子节点并且当前节点对应的pathSum是否等于target
            if (node.left == null && node.right == null && pathSum == targetSum) {
                return true;
            }
            //右子节点入栈
            if (node.right != null) {
                nodeStack.push(node.right);
                pathSumStack.push(pathSum + node.right.val);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                pathSumStack.push(pathSum + node.left.val);
            }
        }
        return false;
    }

    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        //先序遍历
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return false;
        }
        //左子树
        if (root.left != null) {
            targetSum = targetSum - root.left.val;
            if (dfs(root.left, targetSum)) {
                return true;
            }
            //回溯
            targetSum = targetSum + root.left.val;
        }
        if (root.right != null) {
            targetSum = targetSum - root.right.val;
            if (dfs(root.right, targetSum)){
                return true;
            }
            targetSum = targetSum + root.right.val;
        }
        return false;
    }
}
