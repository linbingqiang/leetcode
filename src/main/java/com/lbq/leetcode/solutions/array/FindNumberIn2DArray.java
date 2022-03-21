package com.lbq.leetcode.solutions.array;

/**
 * @author linbingqiang
 * @since 2022/3/16 1:51 下午
 **/
public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        FindNumberIn2DArray fn = new FindNumberIn2DArray();
        boolean exists = fn.findNumberIn2DArray(matrix, 20);
        System.out.println(exists);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 思路如下：
        // 1. 先从行开始搜索，使用二分法进行搜索，如果存在，则返回true；如果不存在，则返回第一个大于target的列下标
        // 2. 根据上一步返回的列下表，对0 - index的列分别进行二分法查找。如果找到，则返回true，否则返回false。
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            int index = binarySearch(matrix[i], target, 0, matrix[i].length - 1);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
