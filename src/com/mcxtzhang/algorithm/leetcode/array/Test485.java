package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: Max Consecutive Ones
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/13.
 * History:
 */
public class Test485 {


    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            //思路： 分别用cur 和 max，存当前连续count 和 最大的count；。
            //遍历数组，如果是1 cur++，如果是0，更新max，cur归零
            if (null == nums || nums.length < 1) return 0;
            int maxCount = 0, curCount = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 1) {
                    curCount++;
                } else {
                    maxCount = Math.max(curCount, maxCount);
                    curCount = 0;
                }
            }
            maxCount = Math.max(curCount, maxCount);
            return maxCount;


        }
    }
}
