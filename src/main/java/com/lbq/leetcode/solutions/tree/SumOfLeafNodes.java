package com.lbq.leetcode.solutions.tree;

import java.util.Stack;

/**
 * LeetCode:404
 * 左叶子节点之和
 * 左叶子节点定义：对于某个节点，该节点的左字节点不为空，且该节点的左子节点的叶子节点均为空，则该节点
 * 的左子节点即为左叶子节点
 * 1. 递归：可以使用先序遍历
 * 2. 迭代：先序遍历的迭代写法
 * @author linbingqiang
 * @since 2022/2/20 11:15 上午
 */
public class SumOfLeafNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4  = new TreeNode(7);
        TreeNode root5  = new TreeNode(100);

        root.left = root1;
        root.right = root2;

        root1.left = root5;

        root2.left = root3;
        root2.right = root4;

        System.out.println(sumOfLeftLeavesIter(root));

    }

    static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    public static int sumOfLeftLeavesIter(TreeNode root) {
        //先序遍历迭代
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && isLeafNode(node.left)) {
                sum += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }

    public static void dfs(TreeNode root) {
        //先序遍历
        if (root != null) {
            //处理当前节点，当前节点的左子节点不为空且为叶子节点
            if (root.left != null && isLeafNode(root.left)) {
                sum += root.left.val;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
