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
    public static void quickSort(int[] src, int left, int right) {
        if (src == null || left < 0 || right < 0 || left >= src.length || right >= src.length || right - left <= 1)
            return;
        int temp = src[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (temp < src[j] && i < j) {
                j--;
            }
            if (temp > src[j]) {
                src[i] = src[j];
                i++;
            }
            while (temp > src[i] && i < j) {
                i++;
            }
            if (temp < src[i]) {
                src[j] = src[i];
                j--;
            }
        }
        src[i] = temp;
        quickSort(src, left, i - 1);
        quickSort(src, i + 1, right);
    }
}
