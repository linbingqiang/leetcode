package com.lbq.offer.solutions;

import java.util.PriorityQueue;

/**
 * 请设计一个类型KthLargest，它每次从一个数据流中读取一个数字，并得出数据流已经读取的数字中第k（k≥1）大的数字。
 * 该类型的构造函数有两个参数：一个是整数k，另一个是包含数据流中最开始数字的整数数组nums（假设数组nums的长度大于k）。
 * 该类型还有一个函数add，用来添加数据流中的新数字并返回数据流中已经读取的数字的第k大数字。
 */
public class KthLargest {

    private final PriorityQueue<Integer> minHeap;

    private final int size;

    public KthLargest(int size, int[] nums) {
        this.size = size;
        minHeap = new PriorityQueue<>();
        for (Integer num : nums) {
            add(num);
        }
    }

    public Integer add(Integer val) {
        if (minHeap.size() < size) {
            // 如果当前堆的数量小于size，则直接添加元素
            minHeap.offer(val);
        } else {
            // 当前元素大于或等于堆顶元素，则删除堆顶元素
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int size = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(size, nums);
        System.out.println(kthLargest.add(3)); // 预期输出4
        System.out.println(kthLargest.add(6)); // 预期输出5
    }
}
