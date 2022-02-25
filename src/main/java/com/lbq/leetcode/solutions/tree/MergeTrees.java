package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode:合并二叉树
 * @author linbingqiang
 * @since 2022/2/26 12:24 上午
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 迭代处理法
     * 利用队列的方式处理
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTreesIter(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            // root1
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val += node2.val;
            //左子树和右子树入队
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer((node2.left));
            }
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            //因为我们最终返回的是root1，所以我们不需要判断node1不为空的情况
            //即当node1.left != null && node2.left == null这个情况下，node1.left还是自己本身，不需要做任何处理
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
