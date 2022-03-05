package com.lbq.leetcode.solutions.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode:1171
 *
 * @author linbingqiang
 * @since 2022/3/5 7:12 下午
 */
public class RemoveZeroSumSubLists {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(-3);
//        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-1);
        head.next = node4;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        RemoveZeroSumSubLists rz = new RemoveZeroSumSubLists();
        ListNode newHead = rz.removeZeroSumSubLists1(head);
        LinkedListUtils.printLinkedList(newHead);
    }

    /**
     * 单链表前缀和
     * 遍历链表，记录当前节点的前缀和，如果之前存在这个和，说明中间存在和为0的节点
     * 1. 利用Map记录前缀和sum和当前节点P
     * 2. 如果Map中不存在该sum，则加入Map
     * 3. 如果Map中存在该sum，则将该sum对应的节点的node.next指向当前节点p.next
     * 4. 更新Map，将被断开部分的节点从Map中删除
     * @param head 链表头结点
     * @return
     */

    public ListNode removeZeroSumSubLists(ListNode head) {
        Map<Integer, ListNode> preSumNodeMap = new HashMap<>();
        ListNode dummy = new ListNode();
        dummy.next = head;

        int sum = 0;
        preSumNodeMap.put(0, dummy);
        ListNode curr = head;
        while (curr != null) {
            sum += curr.val;
            if (preSumNodeMap.containsKey(sum)) {
                ListNode node = preSumNodeMap.get(sum);
                ListNode del = node.next;
                node.next = curr.next;

                int deleteSum = sum;
                while (del != curr) {
                    deleteSum += del.val;
                    preSumNodeMap.remove(deleteSum);
                    del = del.next;
                }
            } else {
                preSumNodeMap.put(sum, curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSubLists1(ListNode head) {
        Map<Integer, ListNode> preSumNodeMap = new HashMap<>();
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 维护前缀和与最后一个节点的关系
        int sum = 0;
        preSumNodeMap.put(0, dummy);
        ListNode curr = head;
        while (curr != null) {
            sum += curr.val;
            preSumNodeMap.put(sum, curr);
            curr = curr.next;
        }

        //遍历链表，当遍历到某一个节点的前缀和在map中存在，则需要处理链表的指针映射关系
        curr = dummy;
        sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (preSumNodeMap.containsKey(sum)) {
                ListNode node = preSumNodeMap.get(sum);
                curr.next = node.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
