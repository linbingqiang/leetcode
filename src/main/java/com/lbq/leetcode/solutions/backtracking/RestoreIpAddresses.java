package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode:93
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 复原IP地址
 * String s = "0000"
 * String s = "101023"
 * ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * @author linbingqiang
 * @since 2022/3/6 5:05 下午
 */
public class RestoreIpAddresses {

    private List<String> result = new ArrayList<>();

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("101023");
//        sb.insert(1, '.');
//        System.out.println(sb.toString());
//        sb.deleteCharAt(1);
//        System.out.println(sb.toString());
        RestoreIpAddresses ria = new RestoreIpAddresses();
        String s = "101023";
        ria.restoreIpAddresses(s);
        System.out.println(ria.result);
    }

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return result;
    }

    public void backtracking(StringBuilder sb, int pointNum, int startIndex) {
        //判断终止条件
        if (pointNum == 3) {
            //判断第4段字符是否合法
            if (isValid(sb, startIndex, sb.length() - 1)) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb, startIndex, i)) {
                sb.insert(i + 1, '.');
                pointNum++;
                backtracking(sb, pointNum, i + 2);
                //回溯
                sb.deleteCharAt(i + 1);
                pointNum--;
            } else {
                break;
            }
        }
    }

    public boolean isValid(StringBuilder sb, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (sb.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (sb.charAt(i) > '9' || sb.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + sb.charAt(i) - '0';
            if (num > 255) {
                return false;
            }
        }
        return true;
    }


}
