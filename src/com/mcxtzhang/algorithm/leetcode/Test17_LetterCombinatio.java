package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Intro:
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * <p>
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/5.
 * History:
 */
public class Test17_LetterCombinatio {
    public static void main(String[] args) {
        List<String> strings = new Solution().letterCombinations("234");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.length() < 0) return result;
            int length = digits.length();
            int intput = 0;
            char c;
            for (int i = 0; i < length; i++) {
                c = digits.charAt(i);
                if (c < '2' || c > '9') {
                    return result;
                } else {
                    intput = intput * 10 + c - '0';
                }
            }
            appendChar(intput, result, new StringBuilder());

            return result;
        }

        public void appendChar(int num, List<String> result, StringBuilder sb) {
            if (num <= 0) return;
            String[] strings = map.get(num % 10);
            for (String string : strings) {
                sb.append(string);
                if (num < 10) {
                    result.add(sb.toString());
                } else {
                    appendChar(num / 10, result, sb);
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public static final Map<Integer, String[]> map = new HashMap<>();

        static {
            map.put(2, new String[]{"a", "b", "c"});
            map.put(3, new String[]{"d", "e", "f"});
            map.put(4, new String[]{"g", "h", "i"});
            map.put(5, new String[]{"j", "k", "l"});
            map.put(6, new String[]{"m", "n", "o"});
            map.put(7, new String[]{"p", "q", "r", "s"});
            map.put(8, new String[]{"t", "u", "v"});
            map.put(9, new String[]{"w", "x", "y", "z"});
        }
    }
}
