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
        int i = minReverseArray(src);
        System.out.println(i);

        src = new int[]{};
         i = minReverseArray(src);
        System.out.println(i);

        src = null;
        i = minReverseArray(src);
        System.out.println(i);

        src = new int[]{5};
        i = minReverseArray(src);
        System.out.println(i);

        src = new int[]{5,5,1,2,3,4};
        i = minReverseArray(src);
        System.out.println(i);
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
}
