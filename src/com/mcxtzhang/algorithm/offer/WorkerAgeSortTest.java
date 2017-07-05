package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 对公司的员工年龄排序
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/29.
 * History:
 */
public class WorkerAgeSortTest {
    public static void main(String[] args) {
        int[] src = new int[]{8, 3, 1, 4, 5, 9, 2};
        ageSort(src);
        for (int i : src) {
            System.out.println(i);
        }

    }

    public static void ageSort(int[] src) {
        if (src == null || src.length <= 1)
            return;
        int range = 99;
        int[] temp = new int[range + 1];

        for (int i = 0; i < src.length; i++) {
            temp[src[i]]++;
        }

        int i = 0;

        for (int i1 = 0; i1 < temp.length; i1++) {
            if (temp[i1] > 0) {
                for (int i2 = 0; i2 < temp[i1]; i2++) {
                    src[i] = i1;
                    i++;
                }
            }
            if (i >= src.length)
                break;
        }

    }
}
