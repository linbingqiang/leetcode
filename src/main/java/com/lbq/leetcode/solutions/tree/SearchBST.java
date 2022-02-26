package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:700
 * 二叉搜索树中的搜索
 * @author linbingqiang
 * @since 2022/2/26 8:29 上午
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        return searchBSTIter(root, val);
    }

    public TreeNode searchBSTRecursion(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBSTRecursion(root.right, val);
        } else {
            return searchBSTRecursion(root.left, val);
        }
    }

    public TreeNode searchBSTIter(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}
