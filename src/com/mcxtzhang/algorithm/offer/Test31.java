package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 连续子数组的最大和
 * <p>
 * 输入一个整形数组，数组里有正数也有负数。
 * 数组中一个或连续的多个数组组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂为O n
 * <p>
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/12.
 * History:
 */
public class Test31 {
    public static void main(String[] args) {
        int[] src = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        maxSubArrayValue(src);
    }

    public static void maxSubArrayValue(int[] src) {
        if (src == null || src.length <= 0) return;
        int lastMax = 0;
        int tempMax = 0;
        for (int i : src) {
            tempMax += i;
            if (tempMax <= i) {
                tempMax = i;
            }
            lastMax = Math.max(lastMax, tempMax);
        }
        System.out.println(lastMax);
    }
}
