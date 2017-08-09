package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/9.
 * History:
 */
public class Test38_CountAndSay {

    public static void main(String[] args) {


    }


    public class Solution {
        public String countAndSay(int n) {
            if (n < 1) return "";
            if (n == 1) return "1";
            StringBuilder result = new StringBuilder();
            int count = 0;
            char temp = ' ';

            String s = countAndSay(n - 1);
            int length = s.length();
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) != temp) {
                    if (count != 0) {
                        result.append(count).append(temp);
                    }
                    temp = s.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
            }
            if (count != 0) {
                result.append(count).append(temp);
            }
            return result.toString();
        }
    }

}
