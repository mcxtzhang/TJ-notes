package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 快速排序
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/29.
 * History:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] src = new int[]{8, 3, 1, 4, 5, 9, 2};
        quickSort(src, 0, src.length - 1);
        for (int i : src) {
            System.out.println(i);
        }

    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] src, int begin, int end) {
        if (src == null || begin < 0 || end < 0 || begin >= src.length || end >= src.length || begin >= end)
            return;
        int l = begin;
        int r = end;
        int temp = src[l];
        while (l < r) {
            while (l < r && temp <= src[r]) {
                r--;
            }
            if (l < r) {
                src[l] = src[r];
                l++;
            }
            while (l < r && temp >= src[l]) {
                l++;
            }
            if (l < r) {
                src[r] = src[l];
                r--;
            }
        }
        src[l] = temp;
        quickSort(src,begin,l-1);
        quickSort(src,l+1,end);
    }
}
