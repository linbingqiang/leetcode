package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:572
 * 一棵树的子树
 * @author linbingqiang
 * @since 2022/2/20 10:48 上午
 */
public class SubTreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(5);
        root.left = root1;
        root.right = root4;
        root1.left = root2;
        root1.right = root3;

        TreeNode subRoot = new TreeNode(4);
        TreeNode subRoot1 = new TreeNode(1);
        TreeNode subRoot2 = new TreeNode(2);
        subRoot.left = subRoot1;
        subRoot.right = subRoot2;

        boolean result = isSubtree(root, subRoot);
        System.out.println(result);
    }

    /**
     * 一棵树的子树，当两个树相等时，也算是子树的一种
     * 1. 判断root和subRoot是不是相同的树
     * 2. 分别递归root.left和root.right，和subRoot比较
     * @param root
     * @param subRoot
     * @return
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
