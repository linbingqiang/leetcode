package com.lbq.leetcode.solutions.linkedlist;

/**
 * 链表节点
 * @author linbingqiang
 * @since 2022/2/23 11:30 下午
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
