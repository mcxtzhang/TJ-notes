package com.mcxtzhang.algorithm.traditional.sort;

/**
 * 插入排序
 * Created by mcxtzhang on 2017/9/26.
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] src = new int[]{1, 3, 7, 143, 41, 5, 7, 8, 3, 6, 4};
        sort(src);
        for (int i : src) {
            System.out.println(i);
        }


    }


    public static void sort(int[] nums) {
        if (null == nums) return;

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }

    }

}
