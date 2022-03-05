package com.lbq.leetcode.solutions.linkedlist;

/**
 * 旋转链表
 * @author linbingqiang
 * @since 2022/3/4 12:41 下午
 **/
public class RotateRightList {

    public static void main(String[] args) {
        // [1,2,3,4,5]
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedListUtils.printLinkedList(head);
        RotateRightList rrl = new RotateRightList();
        ListNode newHead = rrl.rotateRight(head, 3);
        LinkedListUtils.printLinkedList(newHead);
    }

    public ListNode rotateRight(ListNode head, int k) {
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
