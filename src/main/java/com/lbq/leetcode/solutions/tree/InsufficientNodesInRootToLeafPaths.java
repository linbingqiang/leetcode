package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:1080. 根到叶路径上的不足节点
 * https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 *
 * @author linbingqiang
 * @since 2022/3/30 8:14 上午
 **/
public class InsufficientNodesInRootToLeafPaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(-6);
        TreeNode node2 = new TreeNode(-6);
        root.left = node1;
        root.right = node2;
        InsufficientNodesInRootToLeafPaths inp = new InsufficientNodesInRootToLeafPaths();
        System.out.println(inp.sufficientSubset(root, 0));
    }


    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        boolean deleted = dfs(root, limit, 0);
        if (deleted) {
            return null;
        }
        return root;
    }

    /**
     * 深度遍历
     * 后序遍历 左 - 右 -中
     * @param root 待处理节点
     * @param limit 目标值
     */
    public boolean dfs(TreeNode root, int limit, int sum) {
        //叶子节点
        if (root.left == null && root.right == null) {
            return root.val + sum < limit;
        }
        boolean left = true;
        boolean right = true;
        //处理左子树
        if (root.left != null) {
            left = dfs(root.left, limit, sum + root.val);
        }
        //处理右子树
        if (root.right != null) {
            right = dfs(root.right, limit, sum + root.val);
        }
        if (left) {
            //删除左子树
            root.left = null;
        }
        if (right) {
            //删除右子树
            root.right = null;
        }
        return left && right;
    }
}
