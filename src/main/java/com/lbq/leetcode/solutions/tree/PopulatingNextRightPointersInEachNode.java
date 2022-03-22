package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode: 116. 填充每个节点的下一个右侧节点指针
 * root = [1,2,3,4,5,null,7]
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @author linbingqiang
 * @since 2022/3/22 7:20 下午
 **/
public class PopulatingNextRightPointersInEachNode {


    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        PopulatingNextRightPointersInEachNode pnr2 = new PopulatingNextRightPointersInEachNode();
        pnr2.connect(root);
        System.out.println(pnr2.levelOrder(root));
    }

    public Node connectWithoutQueue(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            Node node = null;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    pre = queue.poll();
                    node = pre;
                } else {
                    node = queue.poll();
                    pre.next = node;
                    pre = pre.next;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            pre.next = null;
        }
        return root;
    }

    public List<String> levelOrder(Node root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == 0) {
                    while (node != null) {
                        res.add(String.valueOf(node.val));
                        node = node.next;
                    }
                    res.add("#");
                }

            }
        }
        return res;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
