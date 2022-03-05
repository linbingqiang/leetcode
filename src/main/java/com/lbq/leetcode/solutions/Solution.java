package com.lbq.leetcode.solutions;

/**
 * string to int
 * @author linbingqiang
 * @since 2022/2/24 8:22 下午
 **/
public class Solution {

    public static void main(String[] args) {
        String s3 = "2147483648";
        Integer temp = Integer.valueOf(s3);
        System.out.println(temp);
        Solution solution = new Solution();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(solution.valueOf(s3));
    }

    public Integer valueOf(String s) {
        if (s == null || s == "") {
            return null;
        }
        boolean negative = isNegative(s);
        // 校验
        if (!check(s, negative)) {
            return null;
        }
        //120 = 1 * 10^2 + 2 * 10^1 + 0 * 10^0
        //-120
        Integer result = 0;
        int length = s.length();
        int start = negative ? 1 : 0;
        for (int i = start; i < s.length(); i++) {
            Integer temp =  (s.charAt(i) - '0') * pow(10, length - i -1);
            result += temp;

        }
        result = negative ? -result : result;
        if (negative && result > 0) {
            throw new IllegalArgumentException("overflow");
        }
        if (!negative && result < 0) {
            throw new IllegalArgumentException("overflow");
        }
        return result;
    }

    public boolean isNegative(String s) {
        if (s.charAt(0) == '+') {
            return false;
        }
        return s.charAt(0) == '-';
    }

    public Integer pow(Integer base, Integer n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= base;
        }
        return result;
    }



    public boolean check(String s, boolean negative) {
        int i = negative ? 1 : 0;
        for (int j = i; j < s.length(); j++) {
            if (!Character.isDigit(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
