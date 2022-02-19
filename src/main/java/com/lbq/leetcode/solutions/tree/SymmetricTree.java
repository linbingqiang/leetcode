package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 镜像对称二叉树
 * leetcode:https://leetcode-cn.com/problems/symmetric-tree/
 * @author linbingqiang
 * @since 2022/2/19 1:09 下午
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricRec(root);
    }

    /**
     * 迭代法的处理方式是将需要比较的两个节点依次放入容器，然后再弹出进行比较。
     * 所以使用队列或者栈，甚至是数组都可以。但是弹出操作的时间复杂度可能会比较高
     * @param root root
     * @return
     */
    public boolean isSymmetricIter(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //如果左右子节点都为空
            if (left == null && right == null) {
                continue;
            }
            if (left == null) {
                return false;
            }
            if (right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            //子节点入队
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public boolean isSymmetricRec(TreeNode root) {
        //处理特殊情况
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        //特殊情况处理
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
