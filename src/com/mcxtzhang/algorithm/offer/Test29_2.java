package com.mcxtzhang.algorithm.offer;

/**
 * Intro:数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半。
 * 请找出这个数字。
 * 例如，输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}.输出2
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/12.
 * History:
 */
public class Test29_2 {
    public static void main(String[] args) {
        int[] src = new int[]{8, 3, 1, 4, 5, 9, 2};
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
        System.out.println("结果是:" + moreThanHalfNum(src));

    }

    private static int moreThanHalfNum(int[] src) {
        if (null == src || src.length <= 0)
            return -1;
        int result = src[0];
        int count = 1;
        for (int i = 1; i < src.length; i++) {
            if (count == 0) {
                count = 1;
                result = src[i];
            } else {
                if (src[i] == result) {
                    count++;
                } else {
                    count--;
                    if (count <= 0) {
                        result = src[i];
                        count = 1;
                    }
                }
            }
        }


        //verify
        count = 0;
        for (int i : src) {
            if (i == result) {
                count++;
            }
        }
        if (count * 2 > src.length) {
            return result;
        } else {
            return -2;//没有满足条件的
        }


    }


}
