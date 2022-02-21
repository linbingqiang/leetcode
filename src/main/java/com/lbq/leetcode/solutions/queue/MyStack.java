package com.lbq.leetcode.solutions.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode:225
 * 用队列实现栈:用两个队列实现栈
 * 队列queue1只做临时存储；queue2用于保存数据。所有的操作都通过queue2来完成
 * 只用于临时存储，不永久存储数据
 * @author linbingqiang
 * @since 2022/2/21 11:31 下午
 */
public class MyStack {

    private Queue<Integer> queue1;

    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        //交换queue1和queue2的引用指向
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }


}
