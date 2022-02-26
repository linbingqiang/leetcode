package com.lbq.leetcode.solutions.tree;

/**
 * LeetCode:450
 * 二叉搜索树中删除节点
 * @author linbingqiang
 * @since 2022/2/26 9:09 下午
 */
public class DeleteNodeInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(7);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;
        root2.right = root5;

        DeleteNodeInBST delete = new DeleteNodeInBST();
        delete.deleteNode(root, 3);
        System.out.println(root);
    }

    /**
     * 二叉搜索树的中序遍历序列是递增排列的序列。中序遍历的遍历次序为：left -> node -> right
     * successor代表的是中序遍历序列的下一个节点。即比当前节点大的最小节点，简称后继节点。先取当前节点的右节点，然后一直取该节点的左节点，直到左节点为空。
     * predecessor代表的是中序遍历序列的前一个节点。即比当前节点小的最大节点，简称前驱节点。先取当前节点的左节点，然后一直取该节点的右节点，直到右节点为空、
     * 删除节点有三种可能的情况：
     * 1. 要删除的节点为叶子节点，可以直接删除
     * 2. 要删除的节点不是叶子节点且拥有右节点，则该节点可以由该节点的后继节点进行代替，该后继节点位于右子树中较低的位置，然后从后继节点的位置递归向下操作删除后继节点
     * 3. 要删除的节点不是叶子节点且没有右节点但是有左节点，这意味着它的后继节点在它的上面，使用该节点的前驱节点进行替代，然后再递归向下删除前驱节点。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 右子树中删除
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            //删除root
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                //对应情况二
                TreeNode successor = successor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, root.val);
            } else {
                TreeNode predecessor = predecessor(root);
                root.val = predecessor.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
