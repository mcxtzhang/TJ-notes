package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 数字在排序数组中出现的次数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/19.
 * History:
 */
public class Test38 {
    public static void main(String[] args) {
        int[] a = new int[]{1};
        System.out.println(getKCount(a, 1));

        a = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getKCount(a, 3));
        System.out.println(getKCount(a, 1));
        System.out.println(getKCount(a, 5));
        System.out.println(getKCount(a, 0));


    }

    public static int getKCount(int[] src, int k) {
        if (src == null) return Integer.MIN_VALUE;

        int firstKPosition = getFirstKPosition(src, k);
        int finalKPosition = getFinalKPosition(src, k);
        if (firstKPosition != -1 && finalKPosition != -1) {
            return finalKPosition - firstKPosition + 1;
        }
        return Integer.MIN_VALUE;

    }

    //二分法找到第一个K
    public static int getFirstKPosition(int[] src, int k) {
        if (src == null) return -1;
        int left = 0;
        int right = src.length - 1;
        int middle = (left + right) >>> 1;

        while (left <= right) {
            if (src[middle] == k) {
                if (middle != 0 && src[middle - 1] == k) {
                    right = middle - 1;
                } else {
                    return middle;
                }
            } else if (src[middle] > k) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) >>> 1;
        }
        return -1;
    }

    //二分法找到最后一个K
    public static int getFinalKPosition(int[] src, int k) {
        if (src == null) return -1;
        int left = 0;
        int right = src.length - 1;
        int middle = (left + right) >>> 1;

        while (left <= right) {
            if (src[middle] == k) {
                if (middle != src.length - 1 && src[middle + 1] == k) {
                    left = middle + 1;
                } else {
                    return middle;
                }
            } else if (src[middle] > k) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) >>> 1;
        }
        return -1;
    }
}
