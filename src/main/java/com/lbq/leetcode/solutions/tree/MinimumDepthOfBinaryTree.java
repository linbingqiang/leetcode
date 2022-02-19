package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode:111
 * 二叉树的最小深度
 * 两个大方向：递归解法和迭代解法。
 * 1. 递归解法：实际上和最大深度的解法并不一致。对于根节点只有左子树或者只有右子树的情况下的处理方式和最大深度并不一样。
 * 2. 迭代解法：包含了层序遍历和遍历二叉树的所有路径，并取节点数最小的作为最小深度
 * 遍历二叉树的所有路径，可以参考
 * @see BinaryTreeMaxDepth 的maxDepthWithIter1方法
 * @author linbingqiang
 * @since 2022/2/19 8:58 下午
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        return 0;
    }

    /**
     * 递归解法
     * 1. 当根节点只有左子树时，则最小深度等于 1 + minDepth(root.left);
     * 2. 当根节点只有右子树时，则最小深度等于 1 + minDepth(root.right);
     * 3. 当根节点的左右子均不为空时，则最小深度等于 1 + Math.min(minDepth(root.left), minDepth(root.right))
     * @param root 根节点
     * @return mindepth
     */
    public int minDepthWithRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepthWithRecursion(root.right);
        }
        if (root.right == null) {
            return 1 + minDepthWithRecursion(root.left);
        }
        return 1 + Math.min(minDepthWithRecursion(root.left), minDepthWithRecursion(root.right));
    }

    /**
     * 使用层序遍历进行访问处理，当第一次出现某一层的某个节点的左右子节点均为空时，则此时的深度即为最小深度
     * @param root root
     * @return min depth
     */
    public int minDepthWithLevelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            //处理某一层的叶子节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                //判断是否是叶子节点
                if (node.left == null && node.right == null) {
                    return depth;
                }
            }
        }
        return depth;
    }
}
