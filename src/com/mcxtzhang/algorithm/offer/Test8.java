package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 旋转数组的最小数字
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/29.
 * History:
 */
public class Test8 {

    public static void main(String[] args) {
        int[] src = new int[]{3, 4, 5, 1, 2,};
        System.out.println(minReverseArray(src));
        System.out.println(minReverseArray2(src));

        src = new int[]{};
        System.out.println(minReverseArray(src));
        System.out.println(minReverseArray2(src));

        src = null;
        System.out.println(minReverseArray(src));
        System.out.println(minReverseArray2(src));

        src = new int[]{5};
        System.out.println(minReverseArray(src));
        System.out.println(minReverseArray2(src));



        src = new int[]{1, 2, 3, 4, 5};
        System.out.println(minReverseArray(src));
        System.out.println(minReverseArray2(src));


/*        src = new int[]{5, 5, 1, 2, 3, 4};
        System.out.println(minReverseArray(src));
        System.out.println(minReverseArray2(src));*/
    }


    public static int minReverseArray(int[] src) {
        if (src == null || src.length < 1) return 0;
        if (src.length == 1) return src[0];

        int left = 0;
        int right = src.length - 1;
        while (right - left != 1) {
            int middle = (left + right) / 2;
            int temp = src[middle];
            if (temp > src[left]) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return src[right];

    }


    public static int minReverseArray2(int[] src) {
        if (src == null || src.length < 1) return 0;
        if (src.length == 1) return src[0];

        int left = 0;
        int right = src.length - 1;
        int middle = left;
        while (src[left] > src[right]) {
            middle = (left + right) / 2;
            if (src[middle] > src[left]) {
                left = middle;
            } else if (src[middle] < src[left]) {
                right = middle;
            }
            if (right - left == 1) {
                break;
            }
        }
        return src[middle];

    }
}
