package com.lbq.leetcode.solutions.linkedlist;

/**
 * 链表节点重排
 * 例如链表
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * 经过重排之后，输出结果为:
 * 1 -> 6 -> 2 -> 5 -> 3 -> 4
 * @author linbingqiang
 * @since 2022/4/1 11:35 下午
 */
public class SwapListNodesII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        SwapListNodesII sw = new SwapListNodesII();
        System.out.println("转换前的列表:");
        LinkedListUtils.printLinkedList(head);
        ListNode newHead = sw.swapNodes(head);
        System.out.println("转换后的列表:");
        LinkedListUtils.printLinkedList(newHead);
    }

    public ListNode swapNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middleNode = findMiddle(head);
        //从next节点开始，进行链表翻转
        ListNode newHead = reverse(middleNode.next);
        middleNode.next = null;
        //合并
        ListNode curr = head;
        while (head != null && newHead != null) {
            ListNode firstNext = head.next;
            ListNode secondNext = newHead.next;
            head.next = newHead;
            newHead.next = firstNext;
            head = firstNext;
            newHead = secondNext;
        }
        return curr;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
