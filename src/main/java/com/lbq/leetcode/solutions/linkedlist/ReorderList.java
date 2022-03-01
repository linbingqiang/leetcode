package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode: 143
 * 重排链表
 * @author linbingqiang
 * @since 2022/3/1 11:20 下午
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        ListNode node5 = new ListNode(6);
        node4.next = node5;
        ReorderList rl = new ReorderList();
        rl.reorderList(head);
    }

    public void reorderList(ListNode head) {
        /**
         * 解题思路：
         * 1. 将链表从中间节点进行分割 ==> 如果获取链表的中间节点？？
         * 2. 分别对链表进行翻转      ==> 翻转链表
         * 3. 遍历链表，修改节点指针的关系
         */
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 获取链表的中间节点
        ListNode middle = slow;
        //middle.next = null;
        //翻转链表
        ListNode newHead = reverseList(middle.next);
        middle.next = null;
        LinkedListUtils.printLinkedList(head);
        LinkedListUtils.printLinkedList(newHead);

        //reorder
        ListNode curr = head;
        while (curr != null && newHead != null) {
            ListNode leftNext = curr.next;
            ListNode rightNext = newHead.next;
            //修改指针关系
            curr.next = newHead;
            newHead.next = leftNext;
            curr = leftNext;
            newHead = rightNext;
        }
        LinkedListUtils.printLinkedList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
