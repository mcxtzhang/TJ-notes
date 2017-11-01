package com.mcxtzhang.impotant;

/**
 * Intro:快速排序   http://blog.csdn.net/qy1387/article/details/7752973
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/14.
 * History:
 */
public class QuickSortTst {
    public static void main(String[] args) {
        int[] src = new int[]{8, 3, 1, 4, 5, 9, 2};
        //quickSort(src, 0, src.length - 1);
        quick20171101(src, 0, src.length - 1);
        for (int i : src) {
            System.out.println(i);
        }
    }


    public static void quickSort(int[] nums, int begin, int end) {
        if (nums == null || begin < 0 || end < 0 || begin > nums.length - 1 || begin > nums.length - 1 || begin >= end)
            return;
        int temp = nums[begin];
        int l = begin, r = end;
        while (l < r) {
            while (l < r && temp <= nums[r]) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (l < r && temp >= nums[l]) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = temp;
        quickSort(nums, begin, l - 1);
        quickSort(nums, l + 1, end);

    }

    //2017 11 01 快速排序
    public static void quick20171101(int[] nums, int begin, int end) {
        if (nums == null || nums.length < 1 || begin < 0 || end < 0 || begin > nums.length-1 || end > nums.length-1 || begin >= end)
            return;
        int temp = nums[begin];
        int l = begin;
        int r = end;
        while (l < r) {
            while (l < r && nums[r] >= temp) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }
            while (l < r && nums[l] <= temp) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }


        }
        nums[l] = temp;
        quick20171101(nums, begin, l - 1);
        quick20171101(nums, r + 1, end);


    }


}
