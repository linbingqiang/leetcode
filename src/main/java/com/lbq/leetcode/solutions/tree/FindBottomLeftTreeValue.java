package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode:513
 * 找树左下角的值
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 *
 * 1. 迭代法：层序遍历最后一层的第一个节点
 * 2. 递归法：先序遍历。遍历没一个节点，计算当前节点的深度和值，判断当前这个节点是不是最大深度的节点
 *      所以我们需要有一个全局变量，记录当前最大的深度和最大的值
 * @author linbingqiang
 * @since 2022/2/20 6:56 下午
 */
public class FindBottomLeftTreeValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root2.left = root4;
        root2.right = root5;

        root4.left = root6;

        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
        System.out.println(findBottomLeftTreeValue.findBottomLeftValue(root));
    }

    //全局变量
    int maxDepth = Integer.MIN_VALUE;
    int maxDepthValue = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {
//        return findBottomLeftValueIter(root);
        findBottomLeftValueRecursion(root, 0);
        return maxDepthValue;
    }

    public void findBottomLeftValueRecursion(TreeNode root, int leftDepth) {
        //当前节点如果是叶子节点
        if (root.left == null && root.right == null) {
            if (leftDepth > maxDepth) {
                maxDepth = leftDepth;
                maxDepthValue = root.val;
            }
            return;
        }
        if (root.left != null) {
            leftDepth++;
            findBottomLeftValueRecursion(root.left, leftDepth);
            //回溯
            leftDepth--;
        }
        if (root.right != null) {
            leftDepth++;
            findBottomLeftValueRecursion(root.right, leftDepth);
            leftDepth--;
        }
    }

    public int findBottomLeftValueIter(TreeNode root) {
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> levelOrderList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelOrderList.add(levelList);
        }
        //获取levelOrderList最后一个的第一个数值
        int size = levelOrderList.size();
        return levelOrderList.get(size - 1).get(0);
    }
}
