package com.mcxtzhang.algorithm.offer;

/**
 * Intro:最小的k个数
 * 输入n个整数，找出其中最小的k个数、
 * 例如，输入{4,5,1,6,2,7,3,8}
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/12.
 * History:
 */
public class Test30 {
    public static void main(String[] args) {
        int[] src = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        minNums(src,4);
        minNums(src,0);
        minNums(src,-1);
        minNums(src,2);
        minNums(src,6);
        minNums(src,8);
        minNums(src,9);

    }

    public static void minNums(int[] src, int k) {
        if (src == null || src.length < k || k <= 0) return;

        partition(src, 0, src.length-1, k);

    }

    public static void partition(int[] src, int begin, int end, int k) {
        if (src == null || src.length <= 0 || begin < 0 || end < 0 || begin > end || k <= 0)
            return;
        int l = begin;
        int r = end;
        int temp = src[l];

        while (l < r) {
            while (l < r && temp < src[r]) {
                r--;
            }
            if (temp > src[r]) {
                src[l] = src[r];
                l++;
            }

            while (l < r && temp > src[l]) {
                l++;
            }
            if (temp < src[l]) {
                src[r] = src[l];
                r--;
            }
        }
        src[l]= temp;



        if (l == begin) {
            if (l >= k - 1) {
                System.out.println("这"+k+"个数字是:");
                for (int i = 0; i <= k - 1; i++) {
                    System.out.print(src[i]);
                }
            } else {
                partition(src, l + 1, end, k);
            }
        } else {
            if (l == k - 1) {
                System.out.println("这"+k+"个数字是:");
                for (int i = 0; i <= k - 1; i++) {
                    System.out.print(src[i]);
                }
            } else if (l < k - 1) {
                partition(src, l + 1, end, k);
            } else {
                partition(src, begin, l - 1, k);
            }
        }
    }
}
