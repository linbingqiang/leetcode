package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode:501
 * 二叉搜索树中的众数
 * @author linbingqiang
 * @since 2022/2/26 5:28 下午
 */
public class FindMode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.right = node1;
        node1.right = node2;
        FindMode findMode = new FindMode();
        int[] res = findMode.findMode(root);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    /**
     * 解题思路：
     * 1. 解法1：
     *  由于题目中所给的二叉树是二叉搜索树，所以我们可以通过中序遍历的方式，将所有的二叉搜索树中的值放进List中，然后等价于获取有序数组中的众数。
     * 2. 解法2：
     *  同样是使用中序遍历，不过不使用List来存储，而是通过临时变量的方式。定义两个变量，一个是preVal, preCount，分别代表前一个遍历的值和出现的次数。
     */

    public int[] findMode(TreeNode root) {
        //递归
        traversal(root);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    List<Integer> result = new ArrayList<>();
    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 左子节点
        traversal(root.left);
        //处理当前节点
        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }

        //判断频率
        if (maxCount == count) {
            result.add(root.val);
        }
        //最大值比当前数次少，则说明众数出现变化
        if (maxCount < count) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        }
        pre = root;
        traversal(root.right);
    }
}
