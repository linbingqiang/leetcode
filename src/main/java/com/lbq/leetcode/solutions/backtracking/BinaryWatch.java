package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 401 二进制手表
 * @author linbingqiang
 * @since 2022/4/11 10:44 下午
 */
public class BinaryWatch {

    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        BinaryWatch bw = new BinaryWatch();
        bw.readBinaryWatch(9);
        System.out.println(bw.result);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        int[] bits = new int[10];
        dfs(bits, turnedOn, 0, 0);
        return result;
    }

    public void dfs(int[] bits, int turnedOn, int count, int startIndex) {
        //1. 终止条件
        if (count == turnedOn) {
            //获取数组的组合，判断时间是否有效
            String time = construct(bits);
            if (time != null && !"".equals(time)) {
                result.add(time);
            }
            return;
        }
        for (int i = startIndex; i < bits.length; i++) {
            bits[i] = 1;
            count += 1;
            //递归
            dfs(bits, turnedOn, count, i + 1);
            //回溯
            count -= 1;
            bits[i] = 0;
        }
    }

    public String construct(int[] bits) {
        StringBuilder sb = new StringBuilder();
        //1. 构造小时时间
        int hour = 0;
        for (int i = 3; i >= 0; i--) {
            if (bits[i] == 1) {
                hour += Math.pow(2, 3 - i);
            }
        }
        if (hour > 11) {
            return null;
        }
        if (hour == 0) {
            sb.append("0");
        } else if (hour == 11) {
            sb.append("11");
        } else {
            sb.append(hour);
        }
        sb.append(":");

        //2. 构造分钟
        int minute = 0;
        int pow = 0;
        for (int i = 9; i > 3; i--) {
            if (bits[i] == 1) {
                minute += Math.pow(2, pow);
            }
            pow++;
        }
        if (minute > 59) {
            return null;
        } else if (minute < 10) {
            sb.append("0").append(minute);
        } else {
            sb.append(minute);
        }
        return sb.toString();
    }
}
