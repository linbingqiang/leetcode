package com.lbq.leetcode.solutions.linkedlist;

/**
 * @author linbingqiang
 * @since 2022/2/23 11:48 下午
 */
public class LinkedListUtils {

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

        System.out.println(length(head));
    }

    public static int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}
