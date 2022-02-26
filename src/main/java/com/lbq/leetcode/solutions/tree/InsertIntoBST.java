package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:701
 * 二叉搜索树的插入
 * @author linbingqiang
 * @since 2022/2/26 7:44 下午
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        //确定终止条件
        if (root == null) {
            return new TreeNode(val);
        }

        //确定单层递归逻辑
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    TreeNode parent = null;

    /**
     * 先序遍历
     */
    public void traversal(TreeNode root, int val) {
        // 处理当前节点
        if (root == null) {
            TreeNode node = new TreeNode(val);
            if (parent.val < val) {
                parent.right = node;
            } else {
                parent.left = node;
            }
            return;
        }
        parent = root;
        //处理左右子树
        if (root.val > val) {
            traversal(root.left, val);
        }
        if (root.val < val) {
            traversal(root.right, val);
        }
    }

    public TreeNode insertIntoBSTIter(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        // 搜索待插入节点的父节点
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            parent = cur;
            if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        // 插入节点
        TreeNode node = new TreeNode(val);
        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return root;
    }
}
