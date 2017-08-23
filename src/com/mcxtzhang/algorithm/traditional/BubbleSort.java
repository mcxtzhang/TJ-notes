package com.mcxtzhang.algorithm.traditional;

/**
 * Intro: 冒泡排序
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/23.
 * History:
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] src = new int[]{8, 3, 1, 4, 5, 9, 2};
        bubbleSort(src);
        for (int i : src) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }

    }

    public static void swap(int[] nums, int l, int r) {
        if (l == r) return;
        nums[l] ^= nums[r];
        nums[r] ^= nums[l];
        nums[l] ^= nums[r];
    }
}
