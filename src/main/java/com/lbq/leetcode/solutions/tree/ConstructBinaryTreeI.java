package com.lbq.leetcode.solutions.tree;

/**
 * 二叉树的构建
 * @author linbingqiang
 * @since 2022/2/25 10:56 下午
 */
public class ConstructBinaryTreeI {

    /**
     * inorder = {9, 3, 15, 20, 7}
     * postorder = {9, 15, 7, 20, 3}
     *       3
     *     /  \
     *    9   20
     *       /  \
     *      15   7
     * 解题思路：
     * 1. 后序遍历的最后一个元素为二叉树的根节点
     * 2. 在中序遍历数组中找到根节点的位置
     * 3. 根节点在中序数组中的位置，将中序数组分割成两部分，即二叉树的左子树和右子树
     * 4. 则在后序数组中，也需要将数组分割成左子树和右子树两部分
     * @param inorder 中序遍历
     * @param postorder 后序遍历
     * @return TreeNode
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    // 中序区间[inorderStart, inorderEnd)
    // 后序区间[postorderStart, postorderEnd)
    public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd,
                              int[] postorder, int postorderStart, int postorderEnd) {
        if (postorderStart == postorderEnd) {
            return null;
        }
        // 根节点
        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        //如果数组长度只有一个，则直接返回
        if (postorderEnd - postorderStart == 1) {
            return root;
        }

        //查找rootVal在inorder中的下标位置
        int rootValIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootValIndex = i;
                break;
            }
        }

        //分割中序数组
        //左中序区间：[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inorderStart;
        int leftInorderEnd = rootValIndex;

        //右中序区间
        int rightInorderBegin = rootValIndex + 1;
        int rightInorderEnd = inorderEnd;

        //分割后序数组
        int leftPostorderBegin = postorderStart;
        int leftPostorderEnd = postorderStart + rootValIndex - inorderStart;

        //右后序数组
        int rightPostorderBegin = postorderStart + rootValIndex - inorderStart;
        int rightPostorderEnd = postorderEnd - 1;

        root.left = buildTree(inorder, leftInorderBegin, leftInorderEnd, postorder, leftPostorderBegin, leftPostorderEnd);
        root.right = buildTree(inorder, rightInorderBegin, rightInorderEnd, postorder, rightPostorderBegin, rightPostorderEnd);

        return root;
    }
}
