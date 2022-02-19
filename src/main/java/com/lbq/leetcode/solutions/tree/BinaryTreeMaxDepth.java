package com.lbq.leetcode.solutions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * 二叉树的深度定义为：二叉树的根节点到叶子节点的最长路径
 * 递归法一般使用的是后序遍历：对于某个节点，先分别计算其左右子节点的深度，取其中的最大值，再+1
 * 迭代处理法一般是使用层序遍历：即二叉树的深度等于二叉树的层数
 * @author linbingqiang
 * @since 2022/2/19 7:55 下午
 */
public class BinaryTreeMaxDepth {

    public static void main(String[] args) {
        //构造二叉树 [0,2,4,1,null,3,-1,5,1,null,6,null,8]
        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(-1);
        TreeNode root6 = new TreeNode(5);
        TreeNode root7 = new TreeNode(1);
        TreeNode root8 = new TreeNode(6);
        TreeNode root9 = new TreeNode(8);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        root4.right = root8;
        root5.right = root9;


        int depth = maxDepthWithIter1(root);
        System.out.println(depth);

    }

    public int maxDepth(TreeNode root) {
        //处理特殊条件
        return maxDepthWithRec(root);
    }

    /**
     * 另外一种处理方式是获取从根节点到叶子节点的所有路径，然后取节点数最多的作为二叉树的深度
     * 所以转化为如何获取从根节点到叶子节点的所有路径？
     *          3
     *       /     \
     *      9      20
     *            /  \
     *           15   7
     *  初始状态：
     *  nodeQueue: 3
     *  pathQueue: 3
     *
     *  弹出节点3，因为3不是叶子节点
     *  同时，将3的左右字节点分别入队
     *  nodeQueue: 9, 20
     *  pathQueue: 3-9,3-20
     *
     *  弹出节点9
     *  nodeQueue:20
     *  pathQueue:3-20
     *
     *  因为9是叶子节点，所以得到一条路径是3-9，长度为2
     *
     *  弹出节点20，路径3 - 20
     *  nodeQueue:
     *  pathQueue:
     *
     *  因为20不是叶子节点，所以将左右子节点入队
     *  nodeQueue:15, 7
     *  pathQueue:3-20-15, 3-20-7
     *
     *  执行出队操作，因为15和7都是叶子节点，所以得到两条路径是3-20-15， 3-20-7，长度均为3
     *  所以，得出二叉树的深度为3
     *
     * @param root  root
     * @return depth
     */
    public static int maxDepthWithIter1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<String> pathQueue = new LinkedList<String>();
        nodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));
        int depth = Integer.MIN_VALUE;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            //判断是否是叶子节点
            if (node.left == null && node.right == null) {
                int nodes = path.split(",").length;
                System.out.println(path);
                depth = Math.max(depth, nodes);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(path + "," + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(path + "," + node.right.val);
                }
            }
        }
        return depth;
    }

    /**
     * 使用层序遍历
     * @param root root
     * @return depth
     */
    public int maxDepthWithIter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }

    public int maxDepthWithRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthWithRec(root.left);
        int rightDepth = maxDepthWithRec(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
