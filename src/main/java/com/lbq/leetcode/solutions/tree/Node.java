package com.lbq.leetcode.solutions.tree;

import java.util.List;

/**
 * N叉树的节点定义
 * @author linbingqiang
 * @since 2022/2/19 11:17 上午
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
