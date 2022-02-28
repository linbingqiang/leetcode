package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode:707
 * 设计链表
 * @author linbingqiang
 * @since 2022/2/28 10:29 下午
 */
public class DesignLinkedList {

    public static void main(String[] args) {
        DesignLinkedList dll = new DesignLinkedList();
        dll.addAtHead(2);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        dll.deleteAtIndex(1);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        dll.addAtHead(2);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        dll.addAtHead(7);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        dll.addAtHead(3);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        dll.addAtHead(2);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        dll.addAtHead(5);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        dll.addAtTail(5);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        System.out.println(dll.get(5));
        dll.deleteAtIndex(6);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
        dll.deleteAtIndex(4);
        LinkedListUtils.printLinkedList(dll.dummyHead.next);
    }

    /**
     * 链表长度
     */
    private int size;

    private ListNode dummyHead;

    public DesignLinkedList() {
        dummyHead = new ListNode(-1);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = dummyHead;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        //新节点
        ListNode newHead = new ListNode(val);
        ListNode next = dummyHead.next;
        newHead.next = next;
        dummyHead.next = newHead;
        size++;
    }

    public void addAtTail(int val) {
        ListNode curr = dummyHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        ListNode tail = new ListNode(val);
        curr.next = tail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }
        ListNode curr = dummyHead;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        ListNode next = curr.next;
        ListNode newNode = new ListNode(val);
        newNode.next = next;
        curr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre = dummyHead;
        ListNode curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = curr.next;
        size--;
    }

}
