package com.lbq.leetcode.solutions.tree;

/**
 * 修剪二叉搜索树
 * @author linbingqiang
 * @since 2022/2/26 10:28 下午
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int l, int r) {
        if (root == null) {
            return null;
        }
        //如果当前节点的值小于左区间
        if (root.val < l) {
            return trimBST(root.right, l, r);
        }
        if (root.val > r) {
            return trimBST(root.left, l, r);
        }
        root.left = trimBST(root.left ,l ,r);
        root.right = trimBST(root.right, l, r);
        return root;
    }
}
