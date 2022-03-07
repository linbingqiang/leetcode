package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode:25
 * K个一组翻转链表
 * 解题思路：
 * 1. 设置虚拟头结点dummy
 * 2. 设置临时变量pre，开始时指向dummy节点。临时变量current指向head。
 * 3. 移动current指针，当current不为空且已经走过K个节点时，则进行链表翻转。
 * @author linbingqiang
 * @since 2022/3/7 9:27 下午
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
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
        ReverseNodesInKGroup rk = new ReverseNodesInKGroup();
        ListNode newHead = rk.reverseKGroup(head, 5);
        LinkedListUtils.printLinkedList(newHead);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //获取链表的长度
        int length = getLength(head);
        //计算大概需要分成几个组
        int n = length / k;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        //遍历
        while (n > 0) {
            //移动current，找到需要翻转的节点
            for (int i = 1; i < k; i++) {
                curr = curr.next;
            }
            ListNode currNext = curr.next;
            ListNode preNext = pre.next;
            ListNode newHead = reverse(preNext, curr);
            pre.next = newHead;
            curr = currNext;
            pre = preNext;
            n--;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode curr = head;
        ListNode pre = tail.next;
        while (pre != tail) {
            ListNode currNext = curr.next;
            curr.next = pre;
            pre = curr;
            curr = currNext;
        }
        return pre;
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
