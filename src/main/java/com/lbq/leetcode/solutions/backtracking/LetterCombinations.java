package com.lbq.leetcode.solutions.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode:17
 * 电话号码的字母组合
 * @author linbingqiang
 * @since 2022/3/5 9:32 下午
 */
public class LetterCombinations {

    List<String> result = new ArrayList<>();

    StringBuilder path = new StringBuilder();

    Map<Character, String> map = new HashMap<>();

    public LetterCombinations() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        backtracking(digits, 0);
        return result;
    }

    public void backtracking(String digits, int index) {
        //确定终止条件
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        //单层处理逻辑
        char character = digits.charAt(index);
        String letters = map.get(character);
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtracking(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations lc = new LetterCombinations();
        lc.backtracking(digits, 0);
        System.out.println(lc.result);
    }
}
