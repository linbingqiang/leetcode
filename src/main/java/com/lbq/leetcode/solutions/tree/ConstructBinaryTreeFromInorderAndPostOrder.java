package com.lbq.leetcode.solutions.tree;

import java.util.Arrays;

/**
 * LeetCode: 106
 * 从二叉树的中序遍历和后序遍历构建二叉树
 * @author linbingqiang
 * @since 2022/2/24 1:24 下午
 **/
public class ConstructBinaryTreeFromInorderAndPostOrder {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        ConstructBinaryTreeFromInorderAndPostOrder constructor = new ConstructBinaryTreeFromInorderAndPostOrder();
        TreeNode root = constructor.traversal(inorder, postorder);
        System.out.println(root);
    }

    /**
     * inorder:[9, 3, 15, 20, 7]
     * postorder:[9, 15, 7, 20, 3]
     *             3
     *           /  \
     *          9   20
     *             /  \
     *            15   7
     * 解题思路：
     * 1. 从后序遍历的结构可以知道，后序遍历数组的最后一个元素为根节点。此时可以确认二叉树的根节点位置
     * 2. 此时可以知道根节点的元素是3，在中序遍历数组中，找到元素3，此时将中序数组分割为两部分，即为根节点3的左子树和右子树
     * 3. 将中序数组和后序数组，根据左右子树的方式重新进行递归处理。切分之后需要保证中序数组的左半部分和后序数组的左半部分元素个数相同
     *     中序数组的右半部分和后序数组的右半部分元素个数相同
     * 4. 递归处理左右两部分的数据，构建左子树和右子树
     * @param inorder 中序遍历数组
     * @param postorder 后序遍历数组
     * @return root
     */
    public TreeNode traversal(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        if (postorder.length == 1) {
            return new TreeNode(postorder[postorder.length - 1]);
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

        //查找根节点在中序数组中的位置
        int rootValIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootValIndex = i;
                break;
            }
        }
        //分隔数组
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootValIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootValIndex + 1, inorder.length);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootValIndex);
        int[] rightPostorder = Arrays.copyOfRange(postorder, rootValIndex, postorder.length - 1);

        root.left = traversal(leftInorder, leftPostorder);
        root.right = traversal(rightInorder, rightPostorder);
        return root;
    }


}
