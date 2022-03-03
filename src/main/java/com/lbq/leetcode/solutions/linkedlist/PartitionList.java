package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode:86
 * 分割链表
 * @author linbingqiang
 * @since 2022/3/3 11:18 下午
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        ListNode node5 = new ListNode(2);
        node4.next = node5;
        LinkedListUtils.printLinkedList(head);

        PartitionList pt = new PartitionList();
        ListNode newHead = pt.partition(head, 3);
        LinkedListUtils.printLinkedList(newHead);

        ListNode head1 = new ListNode(1);
        ListNode head11 = new ListNode(1);
        head1.next = head11;
        ListNode newHead1 = pt.partition(head1, 2);
        LinkedListUtils.printLinkedList(newHead1);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode smallHead = new ListNode();
        ListNode smallCurr = smallHead;
        ListNode largeHead = new ListNode();
        ListNode largeCurr = largeHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                smallCurr.next = new ListNode(curr.val);
                smallCurr = smallCurr.next;
            } else {
                largeCurr.next = new ListNode(curr.val);
                largeCurr = largeCurr.next;
            }
            curr = curr.next;
        }
        smallCurr.next = largeHead.next;
        return smallHead.next;
    }

    public ListNode partition1(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr = head;

        ListNode newHead = new ListNode();
        ListNode newCurr = newHead;
        while (curr != null) {
            if (curr.val >= x) {
                newCurr.next = curr;
                newCurr = newCurr.next;
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        newCurr.next = null;
        prev.next = newHead.next;
        return dummyNode.next;
    }

}
