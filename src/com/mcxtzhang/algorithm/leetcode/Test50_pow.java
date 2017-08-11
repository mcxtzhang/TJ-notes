package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/11.
 * History:
 */
public class Test50_pow {


    public static void main(String[] args) {
        new Solution1().myPow(34.00515, -3);

        System.out.println(15 / 2);
        System.out.println(-15 / 2);
    }

    public static class Solution1 {
        public double myPow(double x, int n) {
            if (x == 0) return 0;
            if (x == 1) return 1;
            if (n == 0) return 1;
            if (n == 1) return x;
            if (n == -1) return 1 / x;
            if ((n & 0x01) == 0x01) {
                double v = myPow(x, (n ) >> 1);
                return v * v * x;
            } else {
                double v = myPow(x, n >> 1);
                return v * v;
            }
        }
    }

    //: Time Limit Exceeded
    public class Solution {
        public double myPow(double x, int n) {
            if (x == 0) return 0;
            if (x == 1) return 1;
            if (n == 0) return 1;
            double result;
            boolean negative = false;
            if (n < 0) {
                n = -n;
                negative = true;
            }
            result = x;
            while (--n > 0) {
                result = result * x;
            }
            return negative ? 1 / result : result;
        }
    }
}
