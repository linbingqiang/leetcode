package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:530
 * 把二叉搜索树转换为累加树
 * @author linbingqiang
 * @since 2022/2/26 10:36 下午
 */
public class ConvertBST {

    /**
     * 解题思路：
     * 1. 关键点是提供的是一个二叉搜索树，二叉搜索树的中序遍历是有序的。
     * 2. 有序的数组如何求累加和？例如对于数组[2, 5, 13]，这个数组的累加和为：[20, 18, 13]。
     * 那如果遍历顺序为从右 -> 左遍历，将遍历的位置i -> end的元素逐步累加即可。
     * 相当于是对二叉树的中序遍历(左 -> 中 -> 右)的反方向操作，即：右 -> 中 -> 左的访问顺序.
     * 3. 采用临时变量pre记录当前遍历节点curr的前一个节点。
     */
    int pre;

    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.right);
        root.val += pre;
        pre = root.val;
        traversal(root.left);
    }
}
