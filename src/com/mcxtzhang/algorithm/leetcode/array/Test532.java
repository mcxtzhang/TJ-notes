package com.mcxtzhang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Intro:  532. K-diff Pairs in an Array
 * <p>
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/11/9.
 * History:
 */
public class Test532 {
    class Solution {
        public int findPairs(int[] nums, int k) {
            //排序，从后向前遍历
            if (nums == null || nums.length < 1) return 0;
            int result = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] + k == nums[j]) {
                        result++;
                        break;
                    }
                }
                //去重
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            return result;
        }
    }
}
