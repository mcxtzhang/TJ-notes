package com.mcxtzhang.algorithm.leetcode;

/**
 * +
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Created by pc on 2017/7/31.
 */
public class ReverseInteger {
    public static void main(String[] srgs){
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
    }


    public static class Solution {
        public int reverse(int x) {
            if (x == 0) return 0;

            StringBuilder sb = new StringBuilder();
            if (x < 0) {sb.append("-"); x = -x;}
            while (x != 0) {
                sb.append(x % 10);
                x = x / 10;
            }
            try {
                return Integer.parseInt(sb.toString());
            }catch (NumberFormatException e){
                return 0;
            }
        }
    }
}
