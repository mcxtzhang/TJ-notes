package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半。
 * 请找出这个数字。
 * 例如，输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}.输出2
 * <p>
 * 偶数个，中间应该是 length/2
 * 奇数个，也是 length/2
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/11.
 * History:
 */
public class Test29_1 {

    public static void main(String[] args) {
        int[] src = new int[]{8, 3, 1, 4, 5, 9, 2};
/*        int middleIndex = src.length / 2;
        int num = midNum(src, 0, src.length - 1, middleIndex);
        System.out.println("结果是:" + num);*/
        System.out.println("结果是:" + moreThanHalfNum(src));
        for (int i : src) {
            System.out.println(i);
        }
        System.out.println("二分走一波");
        src = new int[]{8, 3, 1, 4, 5, 9, 2};
        QuickSort.quickSort(src, 0, src.length - 1);
        for (int i : src) {
            System.out.println(i);
        }


        src = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
/*        middleIndex = src.length / 2;
        num = midNum(src, 0, src.length - 1, middleIndex);
        System.out.println("结果是:" + num);*/
        System.out.println("结果是:" + moreThanHalfNum(src));
    }

    public static int moreThanHalfNum(int[] src) {
        if (src == null || src.length == 0) return -1;
        int begin = 0;
        int end = src.length - 1;
        int middle = src.length >> 1;

        int index = midNum(src, begin, end, middle);
        int result = src[index];

        int count = 0;
        for (int i : src) {
            if (i == result) {
                count++;
            }
        }
        if (count * 2 > src.length) {
            return result;
        } else {
            return -2;
        }
    }


    public static int midNum(int[] src, int begin, int end, int middleIndex) {
        if (src == null || src.length == 0 || middleIndex < 0) return -1;

        int left = begin;
        int right = end;
        int base = src[left];
        while (left < right) {
            while (left < right && base < src[right]) {
                right--;
            }
            if (base > src[right]) {
                src[left] = src[right];
                left++;
            }
            while (left < right && base > src[left]) {
                left++;
            }
            if (base < src[left]) {
                src[right] = src[left];
                right--;
            }
        }
        src[left] = base;
/*        if (left == begin) {
            return src[middleIndex];
        } else if (left == middleIndex) {
            return src[left];
        } else if (left > middleIndex) {
            return midNum(src, begin, left, middleIndex);
        } else {
            return midNum(src, left, end, middleIndex);
        }*/


        if (left == begin) {
            return middleIndex;
        } else if (left == middleIndex) {
            return left;
        } else if (left > middleIndex) {
            return midNum(src, begin, left, middleIndex);
        } else {
            return midNum(src, left, end, middleIndex);
        }
    }
}
