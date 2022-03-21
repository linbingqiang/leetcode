package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode: 515. 在每个树行中找最大值
 * 层序遍历，寻找每一行的最大值即可
 *                  5
 *                /   \
 *               4     6
 *             /   \  /  \
 *            1    2 7    8
 *     [5, 6, 8]
 * @author linbingqiang
 * @since 2022/3/21 9:07 上午
 **/
public class FindLargestValueInEachTreeRow {

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

        FindLargestValueInEachTreeRow fl = new FindLargestValueInEachTreeRow();
        List<Integer> res = fl.largestValues(root);
        System.out.println(res);

    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
