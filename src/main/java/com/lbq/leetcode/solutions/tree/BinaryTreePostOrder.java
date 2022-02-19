package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 * leetcode:https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author linbingqiang
 * @since 2022/2/19 12:44 下午
 */
public class BinaryTreePostOrder {

    public List<Integer> postorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        TreeNode preNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //将左子节点入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //出栈
            root = stack.pop();
            //如果当前节点root的右子节点为空或者右子节点已经访问过，则直接放入结果集中
            if (root.right == null || root.right == preNode) {
                result.add(root.val);
                preNode = root;
                root = null;
            } else {
                //右子节点不为空，且没有被访问过
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }
}
