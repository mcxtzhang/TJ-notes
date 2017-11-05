package com.mcxtzhang.algorithm.offer;

/**
 * Intro:
 * 数组中的逆序对.
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字。则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中逆序对的总数。
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/31.
 * History:
 */
public class Test36 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        int coutn = reverseCount(nums);
        System.out.println(coutn);
    }


    public static int reverseCount(int[] nums) {
        if (null == nums || nums.length < 2) return 0;
        //分治，逐步缩减，使数组内部有序，然后比较相邻的两个数组中的逆序对的数量
        //比较两个相邻数组时， 指针分别指向相邻数组的末尾，然后比较，如果p1 > p2 , 则说明有逆序对，则count 要+上， p2数组中还剩的元素数量。同时p1--.
        //如果p2>p1,p2--.  直到没有元素为止
        //所以需要一个辅助数组，存放排序后的数组

        int[] copy = nums.clone();
        return reverseCountHelper(nums, copy, 0, nums.length - 1);
    }

    public static int reverseCountHelper(int[] nums, int[] copy, int begin, int end) {
        if (end - begin == 0) {
            copy[begin] = nums[begin];
            return 0;
        }
        int mid = (begin + end) >>> 1;
        int count = 0;
        count += reverseCountHelper(nums, copy, begin, mid);
        count += reverseCountHelper(nums, copy, mid + 1, end);
        int index = end;
        int p1 = mid;
        int p2 = end;
        while (p1 >= begin && p2 >= mid + 1) {
            if (nums[p1] > nums[p2]) {
                count += p2 - (mid + 1) + 1;
                copy[index--] = nums[p1--];
            } else {
                copy[index--] = nums[p2--];
            }
        }
        for (; p1 >= begin; p1--) {
            copy[index--] = nums[p1];
        }
        for (; p2 >= mid + 1; p2--) {
            copy[index--] = nums[p2];
        }
        //用新数组的值 覆盖原数组
        for (int i = begin; i <= end; i++) {
            nums[i] = copy[i];
        }
        return count;

    }

}
