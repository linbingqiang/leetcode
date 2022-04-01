package com.lbq.leetcode.solutions.array;

/**
 * 剑指offer：II 013. 二维子矩阵的和
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。

 * @author linbingqiang
 * @since 2022/3/23 8:15 上午
 **/
public class NumMatrix {

    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        /**
         * 二维数组的前缀和
         * 定义f(i, j)为矩阵matrix的以(i, j)为右下角的子矩阵的元素之和。
         * 当i = 0 或j = 0，计算f(i, j)只需要对矩阵matrix的最上边的行和最左边的列分别计算前缀和即可。
         * 当i和j都大于0时，可以想到使用f(i, j - 1)、f(i - 1, j)和matrix的值。但是在f(i, j - 1)和f(i - 1, j)之间
         * f(i - 1, j - 1)元素是有重叠的，所以需要减去f(i - 1, j - 1)的值。
         * 所以：
         * f(i, j) = f(i - 1, j) + f(i, j - 1) - f(i - 1, j - 1) + matrix[i][j]
         */
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m][n];
            //初始化第一行的前缀和
            sums[0][0] = matrix[0][0];
            for (int j = 1; j < n; j++) {
                sums[0][j] = sums[0][j - 1] + matrix[0][j];
            }
            //初始化第一列的前缀和
            for (int i = 1; i < m; i++) {
                sums[i][0] = sums[i - 1][0] + matrix[i][0];
            }
            //初始化 i > 0 && j > 0
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > 0 && col1 > 0) {
            return sums[row2][col2] - sums[row1 - 1][col2] - sums[row2][col1 - 1] + sums[row1 - 1][col1 - 1];
        } else if (row1 > 0) {
            //最左列
            return sums[row2][col2] - sums[row1 - 1][col2];
        } else if (col1 > 0) {
            //第一行
            return sums[row2][col2] - sums[row2][col1 - 1];
        }
        return sums[row2][col2];
    }

    public static void main(String[] args) {
        int[][] matrix = {{-4,-5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(0, 1, 0, 1));
    }


}
