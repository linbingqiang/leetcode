package com.lbq.leetcode.solutions.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指offer：50. 第一个只出现一次的字符
 * @author linbingqiang
 * @since 2022/3/22 11:35 下午
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "abbaccdeff";
        FirstUniqChar fuc = new FirstUniqChar();
        char c = fuc.firstUniqChar(s);
        System.out.println(c);
        s = "aaabbbbbcccc";
        System.out.println(fuc.firstUniqChar(s));
        s = "abcdef";
        System.out.println(fuc.firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        if (s == null || s.equals("")) {
            return ' ';
        }
        LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charCount.containsKey(ch)) {
                int count = charCount.get(ch);
                charCount.put(ch, count + 1);
            } else {
                charCount.put(ch, 1);
            }
        }
        if (charCount.size() == 0) {
            return ' ';
        } else {
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() > 1) {
                    continue;
                }
                return entry.getKey();
            }
        }
        return ' ';
    }
}
