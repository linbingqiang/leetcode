package com.lbq.leetcode.solutions.tree;

import java.util.*;

/**
 * LeetCode:103
 * 二叉树的锯齿形遍历
 * 主要的解题思路是：二叉树的层序遍历+双端队列
 * @author linbingqiang
 * @since 2022/3/13 9:06 下午
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(14);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node1.left = node5;
        node1.right = node6;
        BinaryTreeZigzagLevelOrderTraversal zz = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> res = zz.zigzagLevelOrder(root);
        System.out.println(res);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;
        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
