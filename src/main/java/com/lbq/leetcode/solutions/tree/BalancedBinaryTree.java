package com.lbq.leetcode.solutions.tree;

/**
 * 平衡二叉树
 * 1. 定义：一棵二叉树的每个节点的左右两个子树的高度差的绝对值不超过1
 * 2. 高度：该节点到叶子节点的最长简单路径边的条数
 * 3. 深度：根节点从该节点的最长简单路径边的条数
 * 但是LeetCode中的高度和深度都是针对于节点的个数来计算的
 *                        6             高度：4，深度：1
 *                     /     \
 *                    2       8         高度：3，深度：2
 *                  /   \    /  \
 *                 0     4  7    9      高度：2，深度：3
 *                     /  \
 *                     3   5            高度：1，深度：4
 * 所以一般计算节点的高度的时候使用的是后序遍历。
 * @author linbingqiang
 * @since 2022/2/20 9:10 上午
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int result = getHeight(root);
        return result > 0;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
