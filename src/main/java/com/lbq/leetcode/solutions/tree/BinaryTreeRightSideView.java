package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode:199 二叉树的右视图
 * @author linbingqiang
 * @since 2022/3/21 8:24 上午
 **/
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        BinaryTreeRightSideView brsv = new BinaryTreeRightSideView();
        List<Integer> res = brsv.rightSideView(root);
        System.out.println(res);
    }

    /**
     * 解题思路：二叉树的层序遍历，遍历每一层时，返回最后侧的节点即可
     * @param root 二叉树的根节点
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
