package com.lbq.leetcode.solutions.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * LeetCode: 链表随机节点
 * @author linbingqiang
 * @since 2022/2/28 11:03 下午
 */
public class LinkedListRandomNode {

    private List<Integer> valList = new ArrayList<>();

    private Random random;

    public LinkedListRandomNode(ListNode head) {
        while (head != null) {
            valList.add(head.val);
            head = head.next;
        }

        random = new Random();
    }

    public int getRandom() {
        return valList.get(random.nextInt(valList.size()));
    }
}
