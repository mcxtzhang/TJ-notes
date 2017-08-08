package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/8.
 * History:
 */
public class Test33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        //int search = new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5);
        int search = new Solution().search(new int[]{3,1}, 1);
        System.out.println(search);

    }

    public static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length < 1) return -1;
            int left = 0;
            int right = nums.length - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[left]) {//左边有序
                    if (target >= nums[left] && target < nums[mid]) {//二分查找左边
                        right = mid - 1;
                    } else {//继续查找右边
                        left = mid + 1;
                    }
                } else {//右边有序
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                mid = (left + right) / 2;
            }
            return -1;
        }
    }

}
