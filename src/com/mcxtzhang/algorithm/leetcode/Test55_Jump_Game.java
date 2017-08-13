package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/12.
 * History:
 */
public class Test55_Jump_Game {


    public class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null) return false;
            return canReach(nums, nums.length - 1, new int[nums.length]);
        }

        public boolean canReach(int[] nums, int index, int[] cache) {
            if (nums == null || index >= nums.length || index < 0) return false;
            if (index == 0) {
                return true;
            }
            if (cache[index] == 1) {
                return true;
            } else if (cache[index] == -1) {
                return false;
            }

            for (int i = 1; i <= index; i++) {
                if (nums[index - i] >= i && canReach(nums, index - i, cache)) {
                    cache[index] = 1;
                    return true;
                }
            }
            cache[index] = -1;
            return false;
        }
    }
}
