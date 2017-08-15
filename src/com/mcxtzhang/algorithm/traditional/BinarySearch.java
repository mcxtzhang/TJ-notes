package com.mcxtzhang.algorithm.traditional;

import com.mcxtzhang.algorithm.offer.QuickSort;

/**
 * Intro: 二分查找
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/16.
 * History:
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] src = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
/*        System.out.println(binarySearch(src, 1));
        System.out.println(binartSearchFinal(src, 1));

        System.out.println(binarySearch(src, 2));
        System.out.println(binartSearchFinal(src, 2));

        System.out.println(~binarySearch(src, 0));
        System.out.println(~binartSearchFinal(src, 0));*/

        src = new int[]{1, 3, 4};
        System.out.println(~binarySearch(src, 2));
        System.out.println(~binartSearchFinal(src, 2));

        src = new int[]{1, 2, 4};
        System.out.println(~binarySearch(src, 3));
        System.out.println(~binartSearchFinal(src, 3));


        src = new int[]{9, 10, 555, 661, 30, 69, 10, 1, 2, 4};
        QuickSort.quickSort(src, 0, src.length - 1);
        System.out.println(binarySearch(src, 1));
        System.out.println(binartSearchFinal(src, 1));
    }

    //2017 08 15 二分查找究极版
    public static int binartSearchFinal(int[] src, int target) {
        if (null == src || src.length < 1) return -1;
        int left = 0;
        int right = src.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (src[mid] == target) {
                return mid;
            } else if (src[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ~left;

    }

    public static int binarySearch(int[] src, int target) {
        int left = 0;
        int right = src.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (src[middle] == target) {
                return middle;
            } else if (src[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return ~middle;

    }

}
