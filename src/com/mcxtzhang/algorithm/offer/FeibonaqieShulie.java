package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 斐波那契数列
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/29.
 * History:
 */
public class FeibonaqieShulie {
    public static void main(String[] args) {
        System.out.println(getShuLie(9));
    }

    public static long getShuLie(int n) {
        if (n < 0) return 0;
        int[] base = new int[]{0, 1};
        if (n < 2)
            return base[n];

        long base1 = base[0];
        long base2 = base[1];
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = base1 + base2;
            base1 = base2;
            base2 = result;
        }

        return result;
    }
}
