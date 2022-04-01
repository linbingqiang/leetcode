package com.lbq.leetcode.solutions.array;

/**
 * 有序数组中查找某个数出现的次数
 * 二分法的变种题。
 * @author linbingqiang
 * @since 2022/4/1 11:03 下午
 */
public class FindCountInASortedArray {

    public static void main(String[] args) {
        FindCountInASortedArray fc = new FindCountInASortedArray();
        int[] array = {1,2,3,3,3,4,4};
        System.out.println(fc.findCount(array, 5));
    }


    public int findCount(int[] array, int target) {
        int lowerBound = lowerBound(array, target);
        if (lowerBound == -1) {
            return 0;
        }
        int upperBound = upperBound(array, target);
        return upperBound - lowerBound + 1;
    }

    public int lowerBound(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int upperBound(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
