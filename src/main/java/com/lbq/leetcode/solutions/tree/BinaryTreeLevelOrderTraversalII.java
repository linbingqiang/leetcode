package com.lbq.leetcode.solutions.tree;

import java.util.*;

/**
 * LeetCode: 107 二叉树的层序遍历II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 (即按从叶子节点所在层到根节点所在的层，逐 层从左向右遍历)
 *                  5
 *                /   \
 *               4     6
 *             /   \  /  \
 *            1    2 7    8
 *  [[1, 2, 7, 8], [4, 6], [5]]
 * @author linbingqiang
 * @since 2022/3/21 8:31 上午
 **/
public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(6);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(8);
        node2.left = node5;
        node2.right = node6;

        BinaryTreeLevelOrderTraversalII levelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> res = levelOrderTraversalII.levelOrderBottom(root);
        System.out.println(res);
    }

    /**
     * 二叉树层序遍历的变种题。二叉树的层序遍历是使用队列的方式进行处理，我们可以再层序遍历的时候，将每一层的遍历
     * 结果放入栈中，层序遍历结束后，对栈进行以此出栈的操作，就可以返回自底向上的层次遍历结果。
     * @param root 二叉树的根节点
     * @return 自底向上的层次遍历
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<List<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(level);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
