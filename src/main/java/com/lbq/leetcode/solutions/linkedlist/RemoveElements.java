package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode: 203
 * 移除链表中的元素
 * @author linbingqiang
 * @since 2022/2/28 10:23 下午
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(6);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        LinkedListUtils.printLinkedList(head);
        RemoveElements re = new RemoveElements();
        re.removeElements(head, 6);
        LinkedListUtils.printLinkedList(head);
    }

    /**
     * 记得设置dummyNode节点
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                //相等，处理节点， curr节点位置不动，因为后序一个节点还有可能是需要删除的
                curr.next = curr.next.next;
            } else {
                //不相等，移动指针
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
