package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 翻转二叉树
 * link: https://leetcode-cn.com/problems/invert-binary-tree/
 * 1. 递归方法: 先序遍历/后续遍历
 * 2. 迭代处理: 上述两种遍历方式对应的迭代处理以及层序遍历
 * @author linbingqiang
 * @since 2022/2/19 10:44 上午
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return invertTreeByPreorder(root);
    }

    /**
     * 先序遍历处理节点翻转：中 -> 左 -> 右
     * @param root root
     * @return root
     */
    public TreeNode invertTreeByPreorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeByPreorder(root.left);
        invertTreeByPreorder(root.right);
        return root;
    }

    /**
     * 先序遍历迭代处理
     * @param root root
     * @return root
     */
    public TreeNode invertTreeByPreorderIter(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 翻转当前节点的左右子节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 处理当前节点的左右子节点，当左右子节点不为空时，则加入到栈中
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return root;
    }

    /**
     * 后序遍历：左 -> 右 -> 中
     * @param root root
     * @return root
     */
    public TreeNode invertTreeByPostorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 处理左右子节点
        invertTreeByPostorder(root.left);
        invertTreeByPostorder(root.right);
        //处理翻转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    /**
     * 层序遍历
     * @param root root
     * @return root
     */
    public TreeNode invertTreeByLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //必须先获取当前队列里面的数量，因为在循环里面会对队列进行offer操作，size会一直在变
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                //翻转当前node的左右子节点
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
