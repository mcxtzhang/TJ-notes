package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: 643. Maximum Average Subarray I
 * <p>
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/11/8.
 * History:
 */
public class Test643 {

    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            if(nums == null || nums.length<k) return 0;

            //先累加0~k-1 ,
            double tempSum =  0 ;
            for(int i=0; i<k;i++){
                tempSum += nums[i];
            }
            double maxSum = tempSum;
            //再从k开始遍历，每次遍历时 ,加上nums[i] , -nums[i-k] ,然后取最大值
            for(int i=k;i<nums.length;i++){
                tempSum = tempSum + nums[i] - nums[i-k];
                maxSum = Math.max(tempSum,maxSum);
            }

            return maxSum/k;


        }
    }
}
