package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/15.
 * History:
 */
public class Test27_RemoveElement {
    public class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length < 1) return 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[count++] = nums[i];
                }
            }
            return count;
        }
    }
}
