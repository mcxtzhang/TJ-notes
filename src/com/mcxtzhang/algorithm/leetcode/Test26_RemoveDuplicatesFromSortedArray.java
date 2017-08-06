package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro: 26. Remove Duplicates from Sorted Array
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/6.
 * History:
 */
public class Test26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

    }

    public static class Solution {
        public int removeDuplicates(int[] nums) {
            if (null == nums || nums.length < 1) return 0;
            if (nums.length == 1) return 1;
            int index = 0;
            //如果不同，index++，此时 index 和 i 增速一致。
            //但如果相同，就只有i+++，index 没加。

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[index]) {
                    index++;
                    nums[index] = nums[i];
                }
            }
            return index + 1;
        }
    }
}
