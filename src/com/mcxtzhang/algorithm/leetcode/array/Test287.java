package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: 287. Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/19.
 * History:
 */
public class Test287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            if (nums == null || nums.length < 1) return -1;
            //二分的思想 每次取位于检测区间的中间mid的数字，判断 比这个中间数字 《=的元素的个数count，
            //如果count>mid, 则说明 小于等于 mid的数量，超过了mid，则 begin~mid之间一定有重复的，则 end = mid-1;
            //否则  begin = mid+1
            //
            int len = nums.length;
            int begin = 0;
            int end = len - 1;
            int mid;

            while (begin <= end) {
                mid = (begin + end) >>> 1;

                int count = 0;
                for (int i = 0; i < len; i++) {
                    if (nums[i] <= mid) {
                        count++;
                    }
                }

                if (count > mid) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }


            }
            return begin;


        }
    }
}
