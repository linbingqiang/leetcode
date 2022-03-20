package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linbingqiang
 * @since 2022/3/20 3:45 下午
 */
public class PathSumII {

    private List<List<Integer>> result = new LinkedList<>();
    private Deque<Integer> path = new LinkedList<>();

    private int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(11);
        node1.left = node3;
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        node3.left = node6;
        node3.left = node7;
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(5);
        node5.left = node9;
        node5.left = node8;

        PathSumII ps = new PathSumII();
        List<List<Integer>> res = ps.pathSum(root, 22);
        System.out.println(res);


    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        dfs(root, target);
        return result;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val) ;
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }

    public boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
