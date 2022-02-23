package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode:92
 * 翻转链表II
 * @author linbingqiang
 * @since 2022/2/23 11:29 下午
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        //before reverse
        LinkedListUtils.printLinkedList(head);
        reverseLinkedListII.reverseBetween(head, 2, 5);
        //after reverse
        LinkedListUtils.printLinkedList(head);
    }

    /**
     * 解题思路:
     * 针对链表 dummyNode -> 1 -> 2 -> 3 -> 4 -> 5, left = 2, right = 4
     *                      pre  left          right  temp
     * 我们定义一个指针变量pre，指向left对应的node的前一个节点，定义指针变量rightNode指向right位置的节点
     * 同时定义变量temp，暂存rightNode的下一个节点5.
     * 此时，我们将left和right之间的链表从主链表中断开，即pre.next = null, right.next = null。
     * 如下所示：
     *  dummyNode -> 1 -> null   2 -> 3 -> 4 -> null   5
     *  此时我们将链表 2 ->3 ->4进行翻转，得到的链表如下：
     *  dummyNode -> 1 -> null   null <- 2 <- 3 <- 4   5
     *  此时，我们将pre.next = right, left.next = temp
     *  将链表重新连接
     */


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //定义变量pre和leftNode
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode leftNode = pre.next;

        //定义变量rightNode，指向pre
        ListNode rightNode = pre;
        //移动rightNode，使得rightNode指向目标节点
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        //暂存下一个节点
        ListNode temp = rightNode.next;

        //断开链表
        pre.next = null;
        rightNode.next = null;

        //翻转leftNode -> rightNode的链表
        reverseList(leftNode);

        //重新连接
        pre.next = rightNode;
        leftNode.next = temp;
        return dummyNode.next;
    }

    public void reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }
}
