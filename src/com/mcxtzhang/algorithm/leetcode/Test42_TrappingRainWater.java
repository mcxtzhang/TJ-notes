package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/10.
 * History:
 */
public class Test42_TrappingRainWater {
    public static void main(String[] args) {
        int[] src = new int[]{0, 2, 0};
        new Solution().trap(src);
    }

    public static class Solution {
        public int trap(int[] height) {
            if (height == null || height.length <= 1) return 0;
            int result = 0;

            int[] maxHeight = new int[height.length];
            int tempMax = 0;
            for (int i = 0; i < height.length; i++) {
                tempMax = Math.max(tempMax, height[i]);
                maxHeight[i] = tempMax;
            }
            tempMax = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                tempMax = Math.max(tempMax, height[i]);
                maxHeight[i] = Math.min(maxHeight[i], tempMax);
                result += maxHeight[i] - height[i];
            }
            return result;
        }
    }
}
