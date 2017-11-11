package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro:  674. Longest Continuous Increasing Subsequence
 * <p>
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * Note: Length of the array will not exceed 10,000.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/11/7.
 * History:
 */
public class Test674 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if(null == nums || nums.length<1) return 0;
            if(nums.length<2) return 1;

            int maxCount = 1;
            int tempCount = 1;
            for(int i=1;i<nums.length;i++){
                if(nums[i] > nums[i-1] ){
                    tempCount++;
                }else{
                    maxCount = Math.max(maxCount,tempCount);
                    tempCount = 1;
                }
            }
            maxCount = Math.max(maxCount,tempCount);
            return maxCount;




        }
    }
}
