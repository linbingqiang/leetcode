package com.lbq.leetcode.solutions.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode:无重复字符的最长子串
 * @author linbingqiang
 * @since 2022/4/18 10:48 下午
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ls.lengthOfLongestSubstringWithMap("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstringWithMap("bbbbb"));
        System.out.println(ls.lengthOfLongestSubstringWithMap("pwwkew"));
    }

    public int lengthOfLongestSubstringWithMap(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        map.put(arr[left], left);
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            char ch = arr[i];
            if (map.containsKey(ch)) {
                //重复
                int index = map.get(ch);
                for (int j = left; j <= index; j++) {
                    map.remove(arr[j]);
                }
                left = index + 1;
                map.put(ch, i);
                maxLength = Math.max(maxLength, i - left + 1);
            } else {
                //不重复
                map.put(ch, i);
                maxLength = Math.max(maxLength, i - left + 1);
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chArray = s.toCharArray();
        int slow = 0;
        int fast = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (fast = 0; fast < chArray.length; fast++) {
            while (set.contains(chArray[fast])) {
                set.remove(chArray[slow]);
                slow++;
            }
            set.add(chArray[fast]);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
