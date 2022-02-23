package com.lbq.leetcode.solutions.linkedlist;

/**
 * @author linbingqiang
 * @since 2022/2/23 11:48 下午
 */
public class LinkedListUtils {

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
