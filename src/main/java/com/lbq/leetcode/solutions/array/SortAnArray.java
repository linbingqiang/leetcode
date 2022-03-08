package com.lbq.leetcode.solutions.array;

/**
 * LeetCode: 排序数组
 * @author linbingqiang
 * @since 2022/3/8 10:57 下午
 */
public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        SortAnArray saa = new SortAnArray();
        int[] result = saa.sortArray(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    public int[] sortArray(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        heapSort(nums);
        return nums;
    }


    //*****************  堆排序    ***********************//
    //1. 将数组构建成最大堆 buildMaxHeap(int[] nums, int length)
    //2. 调整最大堆 heapify(int[] nums, int i, int length)
    //3. 堆排序 heapSort
    public void heapSort(int[] nums) {
        //构建最大堆
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 0; i--) {
            //将堆顶元素和最后一个元素互换
            swap(nums, i, 0);
            // 每次互换之后，长度要减1
            len = len - 1;
            heapify(nums, 0, len);
        }
    }

    /**
     * 构建最大堆
     * @param nums
     * @param len
     */
    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            heapify(nums, i, len);
        }
    }

    public void heapify(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left <= len && nums[left] > nums[i]) {
            largest = left;
        }
        if (right <= len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest, len);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    //*****************   快速排序   **********************//

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
