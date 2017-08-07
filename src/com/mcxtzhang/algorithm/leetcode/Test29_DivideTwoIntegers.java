package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/7.
 * History:
 */
public class Test29_DivideTwoIntegers {
    public static void main(String[] args) {
        //System.out.println(new Solution().divide(2, 3));;
        //System.out.println(new Solution().divide(15, 3));
        System.out.println(new Solution().divide(-1, 1));
        ;
        //System.out.println(new Solution().divide(0, 3));;
        // System.out.println(new Solution().divide(3, 0));;
    }

    public static class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 0) return Integer.MAX_VALUE;
            if (dividend == 0) return 0;
            if (dividend == Integer.MIN_VALUE) {
                if (divisor == -1) {
                    return Integer.MAX_VALUE;
                }
            }
            boolean negative = (dividend ^ divisor) >>> 31 == 1;
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);


            int gap = 0;
            int result = 0;
            int temp = divisor << 1;
            while (temp < dividend) {
                if (temp < dividend) {
                    gap++;
                }
                temp = temp << 1;
            }
            temp = temp >> 1;
            System.out.println("temp:" + temp);
            System.out.println("gap:" + gap);

            while (temp >= divisor && dividend != 0) {
                dividend = dividend - temp;
                if (dividend >= 0) {
                    result = result + (gap > 0 ? (2 << (gap - 1)) : 1);
                } else {
                    dividend = dividend + temp;
                }
                gap--;
                temp = temp >> 1;
            }
            return negative ? -result : result;
        }
    }

    //http://blog.csdn.net/linhuanmars/article/details/20024907

}
