package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode:144
 * 二叉树的前序遍历
 * 中 -> 左 -> 右
 * @author linbingqiang
 * @since 2022/3/20 9:00 下午
 */
public class BinaryPreorderTraversal {

    private List<Integer> result = new ArrayList<>();

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

        BinaryPreorderTraversal bpt = new BinaryPreorderTraversal();
        List<Integer> recurResult = bpt.preorderTraversal(root);
        System.out.println(recurResult);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderIter(root);
        return result;
    }

    /**
     * 递归写法
     * @param root 根节点
     */
    public void preorder(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            //左
            preorder(root.left);
            preorder(root.right);
        }
    }

    /**
     * 迭代写法
     * @param root root
     */
    public void preorderIter(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            // 右子节点先入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            // 左子节点入栈
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
