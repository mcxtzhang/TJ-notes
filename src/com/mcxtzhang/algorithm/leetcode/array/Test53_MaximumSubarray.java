package com.mcxtzhang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Intro:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/12.
 * History:
 */
public class Test53_MaximumSubarray {


    public static class Solution2 {

        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length < 0) return 0;
            int max = Integer.MIN_VALUE;
            int[] tempMaxArray = new int[nums.length];
            Arrays.fill(tempMaxArray, Integer.MIN_VALUE);
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(maxSubArrayWithIndex(nums, i, tempMaxArray), max );
            }
            return max;
        }

        public int maxSubArrayWithIndex(int[] nums, int index, int[] tempMaxArray) {
            if (nums == null || nums.length < 0) return 0;
            if (index == 0) {
                tempMaxArray[0] = nums[0];
                return nums[0];
            }
            if (tempMaxArray[index] != Integer.MIN_VALUE) return tempMaxArray[index];

            int lastMax = maxSubArrayWithIndex(nums, index - 1, tempMaxArray);
            if (lastMax <= 0) {
                tempMaxArray[index] = nums[index];
                return nums[index];
            } else {
                tempMaxArray[index] = lastMax + nums[index];
                return tempMaxArray[index];
            }
        }


    }

    public static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length < 0) return 0;
            int currentSum = 0, max = Integer.MIN_VALUE;
            for (int num : nums) {
                currentSum = num + currentSum;
                if (currentSum < num) {
                    currentSum = num;
                }
                max = Math.max(currentSum, max);
            }
            return max;
        }
    }
}
