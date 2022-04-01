package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [1,2,3,null,null,4,5]
 * LeetCode:297. 二叉树的序列化与反序列化
 *                  1
 *                /   \
 *               2     3
 *                   /   \
 *                  4     5
 *                /  \
 *               6    7
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * @author linbingqiang
 * @since 2022/3/28 8:14 上午
 **/
public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node2.left = node3;
        node2.right = node4;

        TreeNode node5 = new TreeNode( 6);
        TreeNode node6 = new TreeNode(7);
        node3.left = node5;
        node3.right = node6;


        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode newRoot = codec.deserialize(serialize);
        System.out.println(newRoot);
    }


    /**
     * 采用层序遍历的方式进行二叉树的序列化，对于空节点，赋予#。例如上述的二叉树序列化后的结果为:1,2,3,#,#,4,5
     * Encodes a tree to a single string.
     * @param root root
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        int height = height(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty() && level <= height) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 需要判断当前node是不是最后一层，如果是最后一层， 就不需要再append了
                if (node == null) {
                    if (level <= height) {
                        sb.append("#");
                        queue.offer(null);
                        queue.offer(null);
                    }
                } else {
                    sb.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                sb.append(",");
            }
            level++;
        }
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }

    private boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    /**
     * 获取二叉树的高度
     * @param node node
     * @return height
     */
    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 0,1,2,3,4,5,6
     * 1,2,3,#,#,4,5
     * 满二叉树。反序列化可以根据数组下标来判断。
     * 对于下标i,它的左子节点下标为2 * i + 1;
     * 对于下标i,它的右子节点下标为2 * i + 2;
     * Decodes your encoded data to tree.
     * @param data data
     * @return root
     */
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] serialize = data.split(",");;
        int length = serialize.length;
        int rootVal = Integer.parseInt(serialize[0]);
        TreeNode root = new TreeNode(rootVal);
        int i = 0;
        constructTreeNode(root, 0, length, serialize);
        return root;
    }

    private void constructTreeNode(TreeNode parent, int parentIndex, int length, String[] serialize) {
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        if (leftIndex < length) {
            String ch = serialize[leftIndex];
            if (!"#".equals(ch)) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(ch));
                parent.left = leftNode;
                constructTreeNode(leftNode, leftIndex, length, serialize);
            }
        }
        if (rightIndex < length) {
            String ch = serialize[rightIndex];
            if (!"#".equals(ch)) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(ch));
                parent.right = rightNode;
                constructTreeNode(rightNode, rightIndex, length, serialize);
            }
        }
    }
}
