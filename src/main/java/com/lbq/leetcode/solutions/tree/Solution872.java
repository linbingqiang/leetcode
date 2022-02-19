package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution872 {

    public static void main(String[] args) {
        // 构造root1
        TreeNode root1 = new TreeNode(3);
        TreeNode node11 = new TreeNode(5);
        TreeNode node12 = new TreeNode(1);
        root1.left = node11;
        root1.right = node12;
        TreeNode node13= new TreeNode(6);
        TreeNode node14 = new TreeNode(2);
        node11.left = node13;
        node11.right = node14;

        TreeNode node15 = new TreeNode(7);
        TreeNode node16 = new TreeNode(4);
        node14.left = node15;
        node14.right = node16;

        TreeNode node17 = new TreeNode(9);
        TreeNode node18 = new TreeNode(8);
        node12.left = node17;
        node12.right = node18;

        List<Integer> leafVal = new ArrayList<>();
        preorder(root1, leafVal);
        System.out.println(leafVal);

    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafVal1 = getLeadNodeVal(root1);
        List<Integer> leafVal2 = getLeadNodeVal(root2);
        if (leafVal1.size() != leafVal2.size()) {
            return false;
        }
        for (int i = 0; i < leafVal1.size(); i++) {
            if (!leafVal1.get(i).equals(leafVal2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> getLeadNodeVal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        // 获取叶子节点的值序列: 前序遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isLeafNode(node)) {
                res.add(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (isLeafNode(root)) {
                res.add(root.val);
            }
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static class TreeNode {
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
}
