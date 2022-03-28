package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode:129 求根节点到叶节点数字之和
 * @author linbingqiang
 * @since 2022/3/23 10:07 下午
 */
public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        SumRootToLeafNumbers sln = new SumRootToLeafNumbers();
        System.out.println(sln.sumNumbers(root));

        TreeNode root1 = new TreeNode(4);
        TreeNode node11 = new TreeNode(9);
        TreeNode node12 = new TreeNode(0);
        root1.left = node11;
        root1.right = node12;

        TreeNode node13 = new TreeNode(5);
        TreeNode node14 = new TreeNode(1);
        node11.left = node13;
        node11.right = node14;
        System.out.println(sln.sumNumbers(root1));

    }

    /**
     * 解题思路：
     * 1. 遍历顺序：先序遍历
     * 2. 使用队列保存遍历过的二叉树节点。当节点为叶子节点时，计算当前路径的数字
     * 3. 使用全局变量sum来保存数字和
     * @param root 二叉树的根节点，保证root不为空
     * @return
     */
    int sum = 0;
    Stack<Integer> path = new Stack<>();

    public int sumNumbers(TreeNode root) {
        dfs(root);
        return sum;
    }

    public int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        path.push(root.val);
        //1. 判断终止条件
        if (isLeafNode(root)) {
            sum += sumOfPath(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            dfs(root.left);
            path.pop();
        }
        if (root.right != null) {
            dfs(root.right);
            path.pop();
        }
    }

    public int sumOfPath(List<Integer> path) {
        int sum = 0;
        int size = path.size();
        for (int i = 0; i < size; i++) {
            Integer val = path.get(i);
            sum += val * Math.pow(10, size - i - 1);
        }
        return sum;
    }

    public boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
