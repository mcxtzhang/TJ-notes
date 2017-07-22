package com.mcxtzhang.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/22.
 * History:
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] sum = new int[]{3, 2, 4};
        int[] ints = new Solution().twoSum(sum, 6);
        System.out.println(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            if (nums == null || nums.length < 2) return result;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                int minus = target - nums[i];
                Integer integer = map.get(minus);
                if (integer != null && integer != i) {
                    if (integer > i) {
                        result[0] = i;
                        result[1] = integer;
                    } else {
                        result[0] = integer;
                        result[1] = i;
                    }
                    break;
                }
            }
            return result;
        }
    }
}
