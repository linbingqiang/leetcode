package com.lbq.leetcode.solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的所有路径
 *          1
 *        /   \
 *       2     3
 *      / \
 *     6   5
 *  1 -> 2 -> 5
 *  3 -> 2 -> 6
 *  1 -> 3
 *  所以我们一般采用的是先序遍历，从根节点开始访问。但是需要使用到回溯算法。要知道的是，回溯和递归是一一对一个的，有一个递归，就有一个对应的回溯。
 *  当然，对于上述的递归方式，我们也可以使用迭代的方式来处理，具体对应的处理方式就是先序遍历的迭代处理方法。
 *  我们可以定义一个是节点栈，一个是路径栈
 * @author linbingqiang
 * @since 2022/2/20 9:32 上午
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(6);
        root.left = root1;
        root.right = root2;
        root1.right = root3;
        root1.left = root4;

        List<String> result = binaryTreePaths(root);
        System.out.println(result);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
//        traversal(root, path, result);
        traversalIter(root, result);
        return result;
    }

    /**
     *  *          1
     *  *        /   \
     *  *       2     3
     *  *      / \
     *  *     6   5
     * 开始：
     * nodeStack:1
     * pathStack:1
     *
     * pop:
     * nodeStack:
     * pathStack:
     * path:1
     *
     * push:
     * nodeStack:3
     * pathStack:1 -> 3
     *
     * push:
     * nodeStack:3 2
     * pathStack:1->3, 1->2
     *
     * pop:
     * nodeStack:3
     * pathStack:1->
     * path:1->2
     * node:2
     *
     * push:
     * nodeStack:3,5
     * pathStack:1->3, 1->2->5
     *
     * push:
     * nodeStack:3,5,6
     * pathStack:1->3, 1->2->5, 1->2->6
     *
     * pop:
     * nodeStack:3,5
     * pathStack:1->3, 1->2->5
     *
     * pop:
     * nodeStack:3
     * pathStack:1->3
     *
     * pop:
     * nodeStack:
     * pathStack:1->3
     *
     * //除了用Stack，使用队列的方式也可以。
     * nodeQueue和pathQueue
     * @param root
     * @param result
     */
    public static void traversalIter(TreeNode root, List<String> result) {
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.push(root);
        pathStack.push(String.valueOf(root.val));
        while (!nodeStack.isEmpty()) {
            //取出节点
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();
            //判断当前节点是否是叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
                //这里不能直接return。不然就直接退出循环了。
            }
            //处理左右子节点
            if (node.right != null) {
                nodeStack.push(node.right);
                pathStack.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                pathStack.push(path + "->" + node.left.val);
            }
        }
    }

    /**
     * 先序遍历
     * 一个递归对应一个回溯
     * 中 -> 左 -> 右
     * @param root
     * @param path
     * @param result
     */
    public static void traversal(TreeNode root, LinkedList<Integer> path, List<String> result) {
        //处理当前节点，将当前节点添加到路径当中
        path.add(root.val);
        //判断当前节点是否是叶子节点
        if (root.left == null && root.right == null) {
            //path转换为String
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(String.valueOf(path.get(i)));
                if (i != path.size() - 1) {
                    sb.append("->");
                }
            }
            result.add(sb.toString());
            return;
        }
        //处理左子节点
        if (root.left != null) {
            traversal(root.left, path, result);
            //回溯
            path.removeLast();
        }
        //处理右子节点
        if (root.right != null) {
            traversal(root.right, path, result);
            //回溯
            path.removeLast();
        }
    }
}
