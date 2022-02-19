package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的先序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @author linbingqiang
 * @since 2022/2/19 11:17 上午
 */
public class NTreePreOrder {

    public List<Integer> preorder(Node root) {
        return preorderRec(root);
    }

    /**
     * N叉树先序遍历迭代算法
     * 迭代算法的主要处理过程就是将当前节点的子节点入栈
     * 入栈顺序是从最右边的子节点开始开始入栈，直到最左子节点
     * @param root root
     * @return order list
     */
    public List<Integer> preorderIter(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.children != null && node.children.size() != 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return result;
    }

    public List<Integer> preorderRec(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //处理当前节点
        result.add(root.val);
        // 判断当前root节点的子节点列表是否为空，不为空，从头开始遍历当前的children列表
        if (root.children != null && root.children.size() != 0) {
            for (Node child : root.children) {
                List<Integer> childResult = preorder(child);
                result.addAll(childResult);
            }
        }
        return result;
    }

}
