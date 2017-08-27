package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:Test69_Sqrt
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/27.
 * History:
 */
public class Test69_Sqrt {
    public static void main(String[] args) {
        new Solution().mySqrt(4);
    }

    static class Solution {
        public int mySqrt(int x) {
            if (x <= 1) return x;
            int l = 1;
            int r = x / 2 + 1;
            while (l < r) {

                int m = (l + r) >> 1;
                if (m <= x / m && (m + 1) > (x / (m + 1))) {
                    return m;
                } else if (m < x / m) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;

        }
    }

/*    static class Solution {
        public int mySqrt(int x) {
            if (x <= 1) return x;
            double l = 0;
            double r = x;
            double mid;
            while (l < r) {
                mid = ((l + r) / 2);
                if (Math.abs(mid * mid - x) < 0.01) {
                    return (int) mid;
                } else if (mid * mid < x) {
                    l = mid;
                } else {
                    r = mid;
                }

            }
            return (int) l;

        }
    }*/
}
