package com.lbq.leetcode.solutions.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 1019. 链表中的下一个更大节点
 *
 * todo： 单调栈解法？？？？
 * @author linbingqiang
 * @since 2022/3/20 8:03 下午
 */
public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        NextGreaterNodeInLinkedList ng = new NextGreaterNodeInLinkedList();
        int[] res = ng.nextLargerNodes(head);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(" ");
        }
    }


    public int[] nextLargerNodes(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            boolean flag = false;
            while (next != null) {
                if (next.val > curr.val) {
                    res.add(next.val);
                    flag = true;
                    break;
                } else {
                    next = next.next;
                }
            }
            if (!flag) {
                res.add(0);
            }
            curr = curr.next;
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
