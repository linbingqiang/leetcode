package com.lbq.leetcode.solutions.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode:530
 * 二叉搜索树的最小绝对值差
 * @author linbingqiang
 * @since 2022/2/26 11:09 上午
 */
public class MinimumDifference {

    /**
     * 全局变量，存储二叉树的中序遍历结果
     */
    private List<Integer> inorderList = new ArrayList<>();


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(6);
        root.left = root1;
        root.right = root4;
        root1.left = root2;
        root1.right = root3;

        MinimumDifference minimumDifference = new MinimumDifference();
        minimumDifference.getMinimumDifferenceRecursion(root);
        System.out.println(minimumDifference.min);
    }

    /**
     * 解题思路
     * 1. 要理解题目给的是二叉搜索树，二叉搜索树的中序遍历是一个有序数组，从小到大排列。所以，最小绝对值差只能出现在相邻的两个位置上。
     * 2. 第一种解法是：通过中序遍历返回一个列表，然后遍历获取相邻位置的最小值，返回即可。空间复杂度是O(N)
     * 3. 第二种解法是：无需使用列表，在遍历的过程中，用临时变量pre来存储前一个节点，和当前节点curr的值做差值，和全局变量min做比较
     *      中序遍历完成后，返回min值即为目标最小值
     * @param root 二叉树根节点
     * @return 最小差值
     */
    public int getMinimumDifference(TreeNode root) {
        return getMinimumDifferenceWithList(root);
    }

    public int getMinimumDifferenceWithList(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < inorderList.size(); i++) {
            int diff = inorderList.get(i) - inorderList.get(i - 1);
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            inorderList.add(root.val);
            inorder(root.right);
        }
    }

    /**
     * 临时变量
     * 中序遍历
     * @param root
     * @return
     */

    TreeNode pre = null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifferenceII(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null) {
                int diff = root.val - pre.val;
                min = Math.min(min, diff);
            }
            pre = root;
            root = root.right;
        }
        return min;
    }

    /**
     * 递归处理
     * @param root
     */
    public void getMinimumDifferenceRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        //递归左子树
        getMinimumDifferenceRecursion(root.left);
        //处理当前节点
        if (pre != null) {
            min = Math.min(root.val - pre.val, min);
        }
        pre = root;
        getMinimumDifferenceRecursion(root.right);
    }
}
