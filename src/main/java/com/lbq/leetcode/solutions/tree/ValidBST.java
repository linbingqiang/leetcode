package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode:98
 * 验证二叉搜索树
 * @author linbingqiang
 * @since 2022/2/26 8:48 上午
 */
public class ValidBST {

    private List<Integer> result = new ArrayList<>();

    private Long max = Long.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(6);
        root.left = root1;
        root.right = root2;

        root2.left = root3;
        root2.right = root4;

        ValidBST validBST = new ValidBST();
        System.out.println(validBST.validBSTWithInorder(root));
    }

    /**
     * 思路一
     * 1. 二叉搜索树的中序遍历是一个有序数组，所以我们可以中序遍历二叉搜索树，判断数组是否是有序。
     * 2. 使用临时变量存储变量的值，同样也是使用中序遍历进行遍历，如果访问到的节点出现了小于临时变量的值，则说明不是二叉搜索树
     * @param root root
     * @return true/false
     */

    public boolean isValidBST(TreeNode root) {
        return validBSTWithArray(root);
    }

    public boolean validBSTWithInorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = validBSTWithInorder(root.left);
        if (max < root.val) {
            max = (long) root.val;
        } else {
            return false;
        }
        boolean right = validBSTWithInorder(root.right);
        return left && right;
    }

    public boolean validBSTWithArray(TreeNode root) {
        //中序遍历
        inorder(root);
        //遍历数组，判断是否有序
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i - 1) > result.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            result.add(root.val);
            inorder(root.right);
        }
    }

}
