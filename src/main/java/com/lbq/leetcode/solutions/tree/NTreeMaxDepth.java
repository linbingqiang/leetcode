package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * N叉树的最大深度
 * 1. 迭代
 * 2. 递归
 * @author linbingqiang
 * @since 2022/2/19 8:45 下午
 */
public class NTreeMaxDepth {

    public int maxDepth(Node root) {
        return maxDepthRec(root);
    }

    public int maxDepthIter(Node root) {
        // 层序遍历
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node.children != null && node.children.size() != 0) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            //层数+1
            depth++;
        }
        return depth;
    }

    /**
     * 递归处理
     * @param root
     * @return
     */
    public int maxDepthRec(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null && root.children.size() != 0) {
            //遍历子节点
            for (Node child : root.children) {
                depth = Math.max(depth, maxDepthRec(child));
            }
        }
        return depth + 1;
    }
}
