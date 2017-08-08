package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/8.
 * History:
 */
public class Test34_SearchForARange {

    public static void main(String[] args) {
        new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    public static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length < 1) return null;

            int leftTarget = -1;

            int left = 0;
            int right = nums.length - 1;
            int mid;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] == target) {
                    leftTarget = mid;
                    right = mid - 1;
                    continue;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println("leftTarget:" + leftTarget);

            int rightTarget = -1;
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] == target) {
                    rightTarget = mid;
                    left = mid + 1;
                    continue;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            System.out.println("rightTarget:" + rightTarget);
            return new int[]{leftTarget, rightTarget};
        }
    }
}
