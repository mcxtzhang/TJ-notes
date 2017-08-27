package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/27.
 * History:
 */
public class Test66_PlueOne {

    class Solution {
        public int[] plusOne(int[] digits) {
            if (null == digits || digits.length < 1) return digits;
            int i;
            for (i = digits.length - 1; i >= 0; i++) {
                if (digits[i] != 9) {
                    break;
                }
            }
            if (i == -1) {//各个位都是9
                int[] resut = new int[digits.length + 1];
                resut[0] = 1;
                return resut;
            } else {//中间某位不是9
                //后几位是9，当前位不是9 不需要进位，但需要加1
                digits[i] = digits[i] + 1;
                i++;
                for (; i < digits.length; i++) {
                    digits[i] = 0;
                }
                return digits;
/*                if (i == digits.length - 1) {//第一位就不是9

                } else {

                }*/
            }


        }
    }
}
