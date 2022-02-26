package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:235
 * 二叉搜索树的最近公共祖先
 * @author linbingqiang
 * @since 2022/2/26 7:34 下午
 */
public class LowestCommonAncestorBST {

    /**
     * 确定单层递归的处理逻辑
     * 1. 如果cur.val > p.val && cur.val > q.val，则说明p和q均在左子树，则需要在左子树中查找
     * 2. 如果cur.val < p.val && cur.val < q.val，则说明q和q均在右罪数，则需要在右子树中查找
     * 3. 如果cur.val > p.val && cur.val < q.val || cur.val < p.val && cur.val > p.val
     *    则说明cur节点在区间[p, q]之间，则直接返回cur即可
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
