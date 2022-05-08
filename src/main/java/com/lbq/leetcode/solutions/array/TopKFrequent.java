package com.lbq.leetcode.solutions.array;

import com.lbq.leetcode.solutions.linkedlist.ListNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author linbingqiang
 * @since 2022/5/5 9:02 下午
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] result = topKFrequent.topKFrequent(nums, 2);
        ArrayUtils.printArray(result);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> indexFreqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexFreqMap.containsKey(nums[i])) {
                int freq = indexFreqMap.get(nums[i]);
                indexFreqMap.put(nums[i], freq + 1);
            } else {
                indexFreqMap.put(nums[i], 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (Map.Entry<Integer, Integer> entry : indexFreqMap.entrySet()) {
            pq.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            result[i] = entry.getKey();
        }
        return result;
    }
}
