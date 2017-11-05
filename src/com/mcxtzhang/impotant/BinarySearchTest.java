package com.mcxtzhang.impotant;

/**
 * Intro: 每次去面试前必练习 二分查找
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/14.
 * History:
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] src;
        src = new int[]{1, 3, 4};
        System.out.println(~binarySearch(src, 2));
        System.out.println(~binarySearch20171101(src, 2));
        System.out.println();
        src = new int[]{1, 2, 4};
        System.out.println(~binarySearch(src, 3));
        System.out.println(~binarySearch20171101(src, 3));
        System.out.println();
        src = new int[]{9, 10, 555, 661, 30, 69, 10, 1, 2, 4};
        System.out.println(~binarySearch(src, 3));
        System.out.println(~binarySearch20171101(src, 3));
        System.out.println();
        System.out.println(~binarySearch(null, 3));
        System.out.println(~binarySearch20171101(null, 3));
        System.out.println();
    }

    //2017 09 14
    public static int binarySearch(int[] nums, int k) {
        if (nums == null) return ~0;
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) >> 1;
            if (nums[m] == k) {
                return m;
            } else if (nums[m] > k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ~l;
    }

    //2017 11 01
    public static int binarySearch20171101(int[] nums, int k) {
        if (nums == null || nums.length < 1) return ~0;
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (nums[mid] == k) return mid;
            else if (nums[mid] > k) r = mid - 1;
            else l = mid + 1;
        }
        return ~l;
    }


}
