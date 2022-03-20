package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode: 94 二叉树的中序遍历
 * 左 -> 中 -> 右
 * @author linbingqiang
 * @since 2022/3/20 9:09 下午
 */
public class BinaryTreeInorderTraversal {

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

        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        List<Integer> res = btit.inorderTraversal(root);
        System.out.println(res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderIter(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            result.add(root.val);
            inorder(root.right);
        }
    }

    public void inorderIter(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 将根节点的左右子节点入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //开始进行pop处理
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
    }
}
