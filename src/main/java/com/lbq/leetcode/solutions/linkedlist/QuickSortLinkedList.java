package com.lbq.leetcode.solutions.linkedlist;

import java.util.Random;

/**
 * 单链表快速排序
 * @author linbingqiang
 * @since 2022/3/8 10:32 下午
 */
public class QuickSortLinkedList {

    public static void main(String[] args) {
        QuickSortLinkedList quickSort = new QuickSortLinkedList();
    }

    Random random = new Random();

    public ListNode sortList(ListNode head) {
        //todo
        return head;
    }

    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return null;
    }


    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
