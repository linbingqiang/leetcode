package com.lbq.leetcode.solutions.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author linbingqiang
 * @since 2022/2/28 11:24 下午
 */
public class AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l11 = new ListNode(2);
        l1.next = l11;
        ListNode l12 = new ListNode(4);
        l11.next = l12;
        ListNode l13 = new ListNode(3);
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        ListNode head = addTwoNumbersII.addTwoNumbers(l1, l2);
        LinkedListUtils.printLinkedList(head);
    }

    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        //使用头插法
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur = cur % 10;
            ListNode node = new ListNode(cur);
            node.next = ans;
            ans = node;
        }
        return ans;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //分别对链表进行翻转
        ListNode head1 = reverseLinkedList(l1);
        ListNode head2 = reverseLinkedList(l2);
        int carry = 0;
        ListNode head = new ListNode();
        ListNode curr = head;
        while(head1 != null && head2 != null) {
            int sum = head1.val + head2.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            curr.next = node;
            curr = curr.next;

            //移动链表的头结点
            head1 = head1.next;
            head2 = head2.next;
        }
        //说明链表1长度较长
        while(head1 != null) {
            int sum = head1.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            curr.next = node;
            curr = curr.next;
            head1 = head1.next;
        }

        //说明链表1长度较长
        while(head2 != null) {
            int sum = head2.val + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            curr.next = node;
            curr = curr.next;
            head2 = head2.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        return reverseLinkedList(head.next);
    }

    /**
     * 翻转链表
     */
    public ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
