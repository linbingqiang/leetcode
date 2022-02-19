package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历
 * @author linbingqiang
 * @since 2022/2/19 12:11 下午
 */
public class NTreePostOrder {

    public List<Integer> postorder(Node root) {
        return postorderRec(root);
    }

    public List<Integer> postorderIter(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        //记录上一个已经访问过的节点
        Node preNode = null;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            //当前节点是否需要处理的条件为：当前节点的叶子节点为空或者叶子节点的最后一个节点已经被访问过
            if (node.children == null || node.children.size() == 0
                    || node.children.get(node.children.size() - 1) == preNode) {
                result.add(node.val);
                preNode = node;
            } else {
                //弹出来的node，不需要处理，则需要再次push到栈中
                stack.push(node);
                //暂时不需要处理，则需要将子节点依次入栈：从右向左的顺序访问
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return result;
    }

    public List<Integer> postorderIter1(Node root) {
        //先序遍历 -> 逆序
        //root=[1, null, 3, 2, 4, null, 5, 6]
        //preorder=[1, 3, 5, 6, 2, 4]
        //preorder'=[1,4,2,3,6,5]
        //postorder=[5, 6, 3, 2, 4, 1]
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        //链表，头插法
        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(0, node.val);
            List<Node> children = node.children;
            if (children != null && children.size() != 0) {
                for (Node child : children) {
                    stack.push(child);
                }
            }
        }
        return result;
    }

    public List<Integer> postorderRec(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        List<Node> children = root.children;
        if (children != null && children.size() != 0) {
            for (Node child : children) {
                List<Integer> childResult = postorder(child);
                result.addAll(childResult);
            }
        }
        result.add(root.val);
        return result;
    }
}
