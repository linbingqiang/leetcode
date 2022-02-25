package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:105
 * 前序和中序遍历序列构造二叉树
 * @author linbingqiang
 * @since 2022/2/25 11:32 下午
 */
public class ConstructBinaryTreeII {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * preorder = {3, 9, 20, 15, 7}
     * inorder = {9, 3, 15, 20, 7}
     * @param preorder 前序遍历数组
     * @param preorderBegin 前序遍历起始位置
     * @param preorderEnd 前序遍历结束位置，不包含当前这个位置
     * @param inorder 中序遍历数组
     * @param inorderBegin 中序遍历起始位置
     * @param inorderEnd 中序遍历结束位置，不包含当前位置
     *                   下标位置统一左闭右开
     * @return root
     */
    public TreeNode buildTree(int[] preorder, int preorderBegin, int preorderEnd,
                              int[] inorder, int inorderBegin, int inorderEnd) {
        if (preorderBegin == preorderEnd) {
            return null;
        }
        // 前序遍历的第一个位置为根节点
        int rootVal = preorder[preorderBegin];
        TreeNode root = new TreeNode(rootVal);
        // 只有一个元素，返回根节点
        if (preorderEnd - preorderBegin == 1) {
            return root;
        }
        //在中序数组中查找根节点的位置
        int rootValIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootValIndex = i;
                break;
            }
        }
        //分别对前序数组和中序数组进行分割
        //1. 中序数组分割
        // 中序数组的左半部分[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = rootValIndex;
        //中序数组的右半部分[rightInorderBegin, rightInorderEnd)
        int rightInorderBegin = rootValIndex + 1;
        int rightInorderEnd = inorderEnd;
        //2. 前序数组切割
        //前序数组的左半部分
        int leftPreorderBegin = preorderBegin + 1;
        int leftPreorderEnd = preorderBegin + rootValIndex + 1 - inorderBegin;
        //前序数组的右半部分
        int rightPreorderBegin = preorderBegin + rootValIndex + 1 - inorderBegin;
        int rightPreOrderEnd = preorderEnd;
        root.left = buildTree(preorder, leftPreorderBegin, leftPreorderEnd, inorder, leftInorderBegin, leftInorderEnd);
        root.right = buildTree(preorder, rightPreorderBegin, rightPreOrderEnd, inorder, rightInorderBegin,  rightInorderEnd);
        return root;
    }
}
