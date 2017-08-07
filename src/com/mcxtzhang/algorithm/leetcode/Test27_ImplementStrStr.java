package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/7.
 * History:
 */
public class Test27_ImplementStrStr {

    public static void main(String[] args) {
       // new Solution().strStr("abc", "a");
     //   new Solution().strStr("abc", "b");
        //new Solution().strStr("a", "");
        new Solution2().strStr("mississippi", "issip");
    }

    public static class Solution2 {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;
            int length = haystack.length();
            int needleLength = needle.length();
            if (needleLength == 0) return 0;
            if (length < needleLength) return -1;
            int index = -1;
            int j =-1;
            for (int i = 0; i < length; i++) {
                if (haystack.charAt(i) == needle.charAt(0) && needleLength + i <= length) {
                    //首字符相等 长度不越界 继续判断
                    j = 1;
                    while (j<needleLength){
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            break;
                        }
                        j++;
                    }
                    if (j==needleLength){
                        index = i;
                        break;
                    }
                }
            }
            return index;
        }
    }

    public static class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;
            int length = haystack.length();
            int needleLength = needle.length();
            if (needleLength == 0) return 0;
            if (length < needleLength) return -1;
            int index = -1;
            outter:
            for (int i = 0; i < length; i++) {
                if (haystack.charAt(i) == needle.charAt(0) && needleLength + i <= length) {
                    //首字符相等 长度不越界 继续判断
                    for (int i1 = 1; i1 < needleLength; i1++) {
                        if (haystack.charAt(i + i1) != needle.charAt(i1)) {
                            continue outter;
                        }
                    }
                    index = i;
                    break;
                }
            }
            return index;
        }
    }
}
