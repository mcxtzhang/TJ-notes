package com.mcxtzhang.leetcode;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/22.
 * History:
 */
public class IntegerToRoman {
    public static void main(String[] args) {

        System.out.println(intToRoman(9946));

    }

    static String intToRoman(int num) {
        if (num <= 0) return "";
        String ret = "";
        int number[] = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        String flags[] = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        for (int i = 0; i < 13 && num > 0; i++) {
            if (num < number[i]) continue;
            // cout<< i << " " << number[i] << " - " <<flags[i] << endl;
            while (num >= number[i]) {
                num -= number[i];
                ret += flags[i];
            }

        }
        return ret;
    }
}
