package com.lbq.leetcode.solutions.linkedlist;

/**
 * LeetCode:147
 * 使用插入排序对链表进行排序
 * @author linbingqiang
 * @since 2022/2/27 12:01 上午
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        //表示链表的已排序部分的最后一个节点，初始时为head
        ListNode lastSorted = head;
        //表示下一个待插入的元素
        ListNode curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                //当前元素比上一个已排序的元素值大，所以插入到最后面
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyNode;
                while (prev.next.val <= curr.val)  {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyNode.next;
    }
}
