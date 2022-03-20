package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode: 1290. 二进制链表转整数(easy)
 * 解题思路：
 * 1. 遍历一遍，获取链表的长度
 * 2. 遍历第二遍，转换成数值
 * @author linbingqiang
 * @since 2022/3/20 8:17 下午
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        ConvertBinaryNumberInALinkedListToInteger cb = new ConvertBinaryNumberInALinkedListToInteger();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        System.out.println(cb.getDecimalValue(head));
    }

    public int getDecimalValue(ListNode head) {
        //题目要求链表不能为空，所以head == null这个条件不用考虑了
        int len = length(head);
        ListNode curr = head;
        int sum = 0;
        int index = 1;
        while (curr != null) {
            sum += curr.val * Math.pow(2, len - index);
            curr = curr.next;
            index++;
        }
        return sum;
    }

    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
