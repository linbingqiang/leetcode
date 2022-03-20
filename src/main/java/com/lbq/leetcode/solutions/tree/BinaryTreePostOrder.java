package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 * leetcode:https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * 另外一种解法是有点投机取巧的感觉，具体如下：
 * 因为前序遍历的顺序是中 -> 左 -> 右，而后序遍历的顺序为：左 -> 右 -> 中。所以对先序遍历的访问顺序改为：中 -> 右 -> 左
 * 对比可知，将改造后的前序遍历的访问结果做一次reverse操作，就可以得到二叉树的后序遍历结果。
 * 虽然能得到正确结果，但是不符合二叉树的后序遍历的访问顺序。
 * @author linbingqiang
 * @since 2022/2/19 12:44 下午
 */
public class BinaryTreePostOrder {

    public static void main(String[] args) {
        BinaryTreePostOrder btp = new BinaryTreePostOrder();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(6);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(8);
        node2.left = node5;
        node2.right = node6;

        List<Integer> result = btp.postorder(root);
        System.out.println(result);
    }

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
                // 使用preNode的目的是为了判断该节点的右子节点是不是已经被访问过
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
