package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro: String to Integer (atoi)
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/3.
 * History:
 */
public class Test8 {

    public static void main(String[] args) {
        //new Solution().myAtoi("111");
        // new Solution().myAtoi("2147483648");
        //new Solution().myAtoi("-2147483648");
        //new Solution().myAtoi("    10522545459");
        new Solution().myAtoi("-2147483647");
    }


    public static class Solution {
        public int myAtoi(String str) {
            if (str == null) return 0;
            str = str.trim();
            if (str.length() < 1) return 0;
            //48 - 57 是 数字ascii码的范围

            char c = str.charAt(0);
            boolean negative = false;
            int result = 0;
            if (c == '-') {
                negative = true;
            } else if (c <= 57 && c >= 48) {
                result = c - 48;
            } else if (c != '+') {
                return 0;
            }

            int length = str.length();

            int max_10 = 0x7fffffff / 10;
            int max$10 = 0x7fffffff % 10;
            int min_10 = -(0x80000000 / 10);
            int min$10 = -(0x80000000 % 10);

            for (int i = 1; i < length; i++) {
                c = str.charAt(i);
                if (c > 57 || c < 48) {
                    break;
                } else {
                    if (!negative) {//正
                        if (result > max_10 || (result == max_10 && (c - 48) > max$10)) {// 越界
                            result = 0x7fffffff;
                            break;
                        }
                    } else {//负 越界
                        if (result > min_10 || (result == min_10 && (c - 48) > min$10)) {// 越界
                            result = -0x80000000;
                            break;
                        }
                    }
                    result = result * 10 + c - 48;//越界会break 不越界才会继续走
                }
            }
            return negative ? -result : result;
        }
    }

}
