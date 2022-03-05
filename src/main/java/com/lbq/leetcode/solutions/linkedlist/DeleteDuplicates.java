package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode:删除排序链表中的重复元素II
 * @author linbingqiang
 * @since 2022/3/5 4:40 下午
 */
public class DeleteDuplicates {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        DeleteDuplicates dp = new DeleteDuplicates();
        ListNode newHead = dp.deleteDuplicates(head);
        LinkedListUtils.printLinkedList(newHead);

        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(1);
        ListNode node13 = new ListNode(2);
        ListNode node14 = new ListNode(2);
        head1.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        LinkedListUtils.printLinkedList(dp.deleteDuplicates(head1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        //特殊case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;

        //快慢指针
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            //如果slow和fast的值相等，则fast指针往前移动
            if (slow.val == fast.val) {
                fast = fast.next;
            } else {
                //slow和fast不相等，则判断slow.next是否等于fast
                //如果不相等，则说明slow和fast之间存在相同的元素
                //如果相等，则说明slow和fast之间不存在相同的元素
                if (slow.next == fast) {
                    // 移动pre、slow和fast指针
                    ListNode fastNext = fast.next;
                    ListNode slowNext = fast;
                    fast = fastNext;
                    pre = slow;
                    slow = slowNext;
                } else {
                    ListNode fastNext = fast.next;
                    pre.next = fast;
                    slow = fast;
                    fast = fastNext;
                }
            }
        }
        if (slow.next != null) {
            pre.next = null;
        }
        return dummy.next;
    }
}
