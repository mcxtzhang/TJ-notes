package com.mcxtzhang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Intro: 罗马 转 数字
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/1.
 * History:
 */
public class Test13_RomanToInteger {
    public static void main(String[] args) {
        new Solution().romanToInt("MMCDXXV");
    }

    //beats 66%
    public static class Solution {
        public int romanToInt(String s) {
            if (s == null || s.length() < 1) return 0;
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int len = s.length();
            int result = 0;
            for (int i = len - 1; i >= 0; i--) {
                char c1 = s.charAt(i);
                if (i - 1 >= 0 && map.get(c1) > map.get(s.charAt(i - 1))) {
                    result = result + map.get(c1) - map.get(s.charAt(i - 1));
                    i = i - 1;
                } else {
                    result = result + map.get(c1);
                }
            }
            return result;
        }
    }

    //beats 92.3%
    public class Solution2 {
        public int romanToInt(String s) {
            if (s == null || s.length() < 1) return 0;
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int len = s.length();
            int result = 0;
            int temp1,temp2;

            for (int i = len - 1; i >= 0; i--) {
                temp1 = map.get(s.charAt(i));
                if (i - 1 >= 0 && temp1 > (temp2 = map.get(s.charAt(i - 1)))) {
                    result = result + temp1 - temp2;
                    i = i - 1;
                } else {
                    result = result + temp1;
                }
            }
            return result;
        }
    }

}
