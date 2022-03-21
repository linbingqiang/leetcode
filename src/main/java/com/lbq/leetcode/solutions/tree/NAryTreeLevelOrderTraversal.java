package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode: 429 N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *              1
 *          /   |   \
 *         3    2    4
 *       /  \       / \
 *      5    6     7   8
 * [[1], [3, 2, 4], [5, 6, 7, 8]]
 * @author linbingqiang
 * @since 2022/3/21 8:55 上午
 **/
public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> children = new ArrayList<>();

        Node node1 = new Node(3);
        List<Node> children1 = new ArrayList<>();
        Node node11 = new Node(5);
        Node node12 = new Node(6);
        children1.add(node11);
        children1.add(node12);
        node1.children = children1;

        Node node2 = new Node(2);

        Node node3 = new Node(4);
        List<Node> children2 = new ArrayList<>();
        Node node31 = new Node(7);
        Node node32 = new Node(8);
        children2.add(node31);
        children2.add(node32);
        node3.children = children2;

        children.add(node1);
        children.add(node2);
        children.add(node3);
        root.children = children;

        NAryTreeLevelOrderTraversal nLevelOrder = new NAryTreeLevelOrderTraversal();
        List<List<Integer>> res = nLevelOrder.levelOrder(root);
        System.out.println(res);


    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.children != null && node.children.size() != 0) {
                    for (int j = 0; j < node.children.size(); j++) {
                        queue.offer(node.children.get(j));
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}
