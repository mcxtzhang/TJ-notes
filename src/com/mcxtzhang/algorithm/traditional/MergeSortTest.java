package com.mcxtzhang.algorithm.traditional;

/**
 * Intro: 归并排序
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/14.
 * History:
 */
public class MergeSortTest {
    public static void main(String[] args) {

        int[] src = new int[]{1, 3, 7, 143, 41, 5, 7, 8, 3, 6, 4};
        mergeSort(src, 0, src.length - 1);
        for (int i : src) {
            System.out.println(i);
        }


    }

    public static void mergeSort(int[] src, int begin, int end) {
        if (null == src || src.length <= 1 || begin < 0 || end < 0 || end - begin < 1) return;

        int middle = (begin + end) >> 1;

        mergeSort(src, begin, middle);
        mergeSort(src, middle + 1, end);
        merge2OrderedArray(src, begin, middle, src, middle + 1, end, src, begin);


    }

    public static void merge2OrderedArray(int[] a, int b1, int e1, int[] b, int b2, int e2, int[] c, int b3) {
        if (a == null || b1 < 0 || e1 < 0 || b == null || b2 < 0 || e2 < 0 || a.length + 1 < b1 || a.length + 1 < e1 || b.length + 1 < b2 || b.length + 1 < e2 || c == null)
            return;
        int[] temp = new int[e1 - b1 + e2 - b2 + 2];
        int tempB = 0;

        while (b1 <= e1 && b2 <= e2) {
            if (a[b1] < b[b2]) {
                temp[tempB++] = a[b1++];
            } else {
                temp[tempB++] = b[b2++];
            }
        }
        while (b1 <= e1) {
            temp[tempB++] = a[b1++];
        }
        while (b2 <= e2) {
            temp[tempB++] = b[b2++];
        }

        for (int i : temp) {
            c[b3++] = i;
        }





    }

}
