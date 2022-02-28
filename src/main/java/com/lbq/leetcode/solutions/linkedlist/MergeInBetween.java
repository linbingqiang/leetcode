package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode:1669
 * 合并两个链表
 * @author linbingqiang
 * @since 2022/3/1 12:13 上午
 */
public class MergeInBetween {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        ListNode l16 = new ListNode(6);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;

        ListNode l2 = new ListNode(10000);
        ListNode l21 = new ListNode(10001);
        ListNode l22 = new ListNode(10002);
        ListNode l23 = new ListNode(10003);
        ListNode l24 = new ListNode(10004);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;

        MergeInBetween mib = new MergeInBetween();
        ListNode head = mib.mergeInBetween(l1, 2, 5, l2);
        LinkedListUtils.printLinkedList(head);
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        /**
         * 解题思路：
         * 遍历链表List1，找到下标为a - 1的节点pre，找到下标为b + 1的节点next。
         * 遍历链表List2，找到链表的尾节点 tail
         * pre.next = list2
         * tail.next = next;
         */
        ListNode pre = null;
        ListNode curr = list1;
        for (int i = 0; i < a; i++) {
            pre = curr;
            curr = curr.next;
        }

        curr = list1;
        for (int i = 0; i < b; i++) {
            curr = curr.next;
        }
        ListNode next = curr.next;

        ListNode tail = null;
        curr = list2;
        while (curr.next != null) {
            curr = curr.next;
        }
        tail = curr;

        //链接
        pre.next = list2;
        tail.next = next;

        return list1;
    }
}
