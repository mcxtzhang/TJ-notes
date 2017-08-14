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
        // printResult(src);

        src = new int[]{};
        //printResult(src);

        src = null;
        //printResult(src);

        src = new int[]{5};
        //printResult(src);


        src = new int[]{1, 2, 3, 4, 5};
        printResult(src);

        src = new int[]{1, 0, 1, 1, 1};
        printResult(src);

        src = new int[]{1, 1, 1, 0, 1};
        printResult(src);

/*        src = new int[]{5, 5, 1, 2, 3, 4};
        System.out.println(minReverseArray(src));
        System.out.println(minReverseArray2(src));*/
    }

    private static void printResult(int[] src) {
        System.out.println("输出结果");
        System.out.println(minReverseArray(src));
        System.out.println(minReverseArray2(src));
        System.out.println("20170814:" + getMinInReverArray(src));
    }

    //20170814 再来一次
    public static int getMinInReverArray(int[] src) {
        if (src == null || src.length < 1) return -1;
        int left = 0;
        int right = src.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            //考虑重复 1 0 1 1 1       1 1 1 0 1
            if (src[left] == src[middle] && left != middle) {
                return getMinInArray(src);
            }
            if (src[middle] >= src[left]) {
                if (src[middle] <= right) {
                    return src[left];
                } else {
                    left = middle;
                }
            } else {
                right = middle;
            }
            if (right - left == 1) {
                if (src[right] > src[left]) {
                    left = left;
                } else {
                    left = right;
                }
            }
        }
        return src[left];
    }

    //考虑如果数组有重复的情况
    public static int getMinInArray(int[] src) {
        if (src == null || src.length < 1) return -1;
        int min = src[0];
        for (int i = 1; i < src.length; i++) {
            min = Math.min(min, src[i]);
        }
        return min;
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
