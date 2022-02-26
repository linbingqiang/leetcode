package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:236
 * 二叉树的最近公共祖先
 * @author linbingqiang
 * @since 2022/2/26 7:22 下午
 */
public class LowestCommonAncestor {

    /**
     * 题解思路：
     * 两个节点的公共祖先：应该是使用自底向上的遍历方式，即：后序遍历
     * 在递归函数有返回值的情况下，如果要搜索一条边，递归函数返回值不为空的时候，立刻返回。
     * 如果要搜索整棵树，直接用一个变量left、right接住返回值，这个left和right后续还有逻辑处理的需要。
     * 也就是后序遍历中处理中间节点的逻辑。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //确定递归终止条件
        if (root == p || root == q || root == null) {
            return root;
        }
        //遍历左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        return null;
    }
}
