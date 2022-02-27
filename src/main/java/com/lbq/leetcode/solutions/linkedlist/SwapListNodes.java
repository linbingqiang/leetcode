package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode: 交换链表中的节点
 * https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 * @author linbingqiang
 * @since 2022/2/26 11:38 下午
 */
public class SwapListNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        ListNode node1 = new ListNode(3);
        node.next = node1;
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;

        SwapListNodes swap = new SwapListNodes();
        LinkedListUtils.printLinkedList(head);
        swap.swapNodes(head, 1);
        LinkedListUtils.printLinkedList(head);

    }

    /**
     * 1. 如何找到链表中的倒数第K个节点？=> 双指针法
     * 第一步就是：快指针移动K步
     * 第二步就是：慢指针指向head，快慢指针同时移动，知道fast的next节点为空，则可以找到链表的倒数第K个节点
     */

    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        //链表第K个节点
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        //临时存储
        ListNode temp = fast;
        // 倒数第K个节点
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 交换节点
        int val = temp.val;
        temp.val = slow.val;
        slow.val = val;
        return head;
    }
}
