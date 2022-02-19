package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode:222
 * 完全二叉树的节点数量
 * 1. 不关注是否是完全二叉树，将当前这个二叉树当成是普通的二叉树。可想而知，可以使用递归或者是迭代的方式处理。
 *  对于递归方式，我们的处理方式一般是采用后序的遍历方式，先求左子树的节点数量，再求右子树的节点数量，然后加上当前节点数量1
 *  对于迭代方式，我们可以使用层序遍历的方式，获取每一层的节点个数，最后求和
 * 2. 使用完全二叉树的性质
 * @author linbingqiang
 * @since 2022/2/19 9:27 下午
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;

        CountCompleteTreeNodes completeTreeNodes = new CountCompleteTreeNodes();
        int count = completeTreeNodes.countNodesWithCompleteTreeProperty(root);
        System.out.println(count);
    }

    public int countNodes(TreeNode root) {
        return countNodesWithLevelOrder(root);
    }

    /**
     * 完全二叉树只有两种情况：一种是满二叉树，一种是最后一层的叶子节点没有满
     * 对于情况一来说，可以直接使用2^depth - 1来计算
     * 对于情况二来说，分别递归左右子树，递归到某一深度肯定会有左孩子或者是右孩子为满二叉树，然后依次按照情况1来计算
      * @param root root
     * @return int
     */
    public int countNodesWithCompleteTreeProperty(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = 0, rightHeight = 0;
        //分别计算左右孩子的高度
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        //如果当前节点的左右子节点高度相等，则说明是一个满二叉树
        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        }
        //说明当前节点对应的子树不是一个满二叉树，则继续递归处理
        return countNodesWithCompleteTreeProperty(root.left)
                + countNodesWithCompleteTreeProperty(root.right)
                + 1;
    }

    public int countNodesWithNormalTree(TreeNode root) {
        //确定终止条件
        if (root == null) {
            return 0;
        }
        //分别获取左右子树的节点数量
        int leftCount = countNodesWithNormalTree(root.left);
        int rightCount = countNodesWithNormalTree(root.right);
        return leftCount + rightCount + 1;
    }

    public int countNodesWithLevelOrder(TreeNode root) {
        //层序遍历
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
