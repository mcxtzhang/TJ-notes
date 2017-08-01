package com.mcxtzhang.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by pc on 2017/8/1.
 */
public class Test14_LongestCommonPrefix {
    public static void main(String[] args) {

    }

    //shit, only beats 22%
    public class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length < 1) return "";
            Arrays.sort(strs);

            String str1 = strs[0];
            String str2 = strs[strs.length - 1];
            int length = str1.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (i < str2.length()  && str1.charAt(i) == str2.charAt(i)) {
                    sb.append(str1.charAt(i));
                } else {
                    break;
                }
            }
            return sb.toString();
        }
    }

    //only beats 22%
    public class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length < 1) return "";
            StringBuilder result = new StringBuilder();
            char temp;
            lable:
            for (int i = 0; i < strs[0].length(); i++) {
                temp = strs[0].charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    if (i > strs[j].length() - 1 || strs[j].charAt(i) != temp) {
                        break lable;
                    }
                }
                result.append(temp);
            }
            return result.toString();
        }
    }
}
