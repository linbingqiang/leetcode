package com.lbq.leetcode.solutions.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode: 23
 * 合并K个升序链表
 * @author linbingqiang
 * @since 2022/3/6 5:29 下午
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(5);
        head1.next = node11;
        node11.next = node12;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        head2.next = node21;
        node21.next = node22;

        ListNode head3 = new ListNode(2);
        ListNode node31 = new ListNode(6);
        head3.next = node31;

        ListNode[] lists = new ListNode[] {head1, head2, head3};
        MergeKSortedLists mksl = new MergeKSortedLists();
        ListNode head = mksl.mergeKLists(lists);
        LinkedListUtils.printLinkedList(head);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
