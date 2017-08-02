package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:LongestSubstringWithoutRepeatingCharacters
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/2.
 * History:
 */
public class Test3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //new  Solution().lengthOfLongestSubstring("abcabcbb");
        new Solution().lengthOfLongestSubstring("dvdf");
    }

    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() < 1) return 0;
            int result = 0;
            StringBuilder tempMaxSb = new StringBuilder();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                int index = tempMaxSb.indexOf(String.valueOf(c));
                if (0 <= index) {//found repeat
                    result = Math.max(result, tempMaxSb.length());
                    //注意delete 要 index+1
                    tempMaxSb.delete(0,index+1);
                    //自己要追加进来
                    tempMaxSb.append(c);
                } else {
                    tempMaxSb.append(c);
                }
            }
            if (tempMaxSb.length() > 0) {
                result = Math.max(result, tempMaxSb.length());
            }
            return result;
        }
    }
}
