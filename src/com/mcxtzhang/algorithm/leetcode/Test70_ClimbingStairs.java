package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/27.
 * History:
 */
public class Test70_ClimbingStairs {

    class Solution3 {
        public int climbStairs(int n) {
            if (n < 1) return 0;
            if (n == 1) return 1;
            if (n == 2) return 2;

            int last1 = 1, last2 = 2, result = 0;
            int temp = 3;
            while (temp <= n) {
                result = last1 + last2;
                last1 = last2;
                last2 = result;
                temp++;
            }
            return result;
        }
    }

    //9.3% beats
    class Solution2 {
        public int climbStairs(int n) {
            if (n < 1) return 0;
            if (n == 1) return 1;
            if (n == 2) return 2;

            int last1 = 1, last2 = 2, result = 0;
            int temp = 3;
            while (temp <= n) {
                result = last1 + last2;
                last1 = last2;
                last2 = result;
                temp++;
            }
            return result;
        }
    }

    //can not pass
    class Solution {
        public int climbStairs(int n) {
            if (n < 1) return 0;
            if (n == 1) return 1;
            if (n == 2) return 2;
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
