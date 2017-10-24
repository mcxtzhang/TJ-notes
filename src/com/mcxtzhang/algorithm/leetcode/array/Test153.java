package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: 153. Find Minimum in Rotated Sorted Array
 * <p>
 * .Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/24.
 * History:
 */
public class Test153 {
    class Solution {
        public int findMin(int[] nums) {
            if (null == nums || nums.length < 1) return 0;
            if (nums.length == 2) {
                return Math.min(nums[0], nums[1]);
            }

            //二分 每次比较中间的 和 左边的，如果mid小于begin，则修正 end = mid
            //如果mid >begin,继续判断 mid 和end， 如果mid<end ,返回min即可。  如果mid>end,则begin = mid;继续
            //最终当beign end 相邻 end就是答案
            int begin = 0;
            int end = nums.length - 1;
            int mid;
            //要考虑 1 数组原本就有序 2 数组的数量为2，即【1,2】
            while (end - begin > 1) {
                mid = (begin + end) >>> 1;
                if (nums[mid] <= nums[begin]) {
                    end = mid;
                } else {
                    if (nums[mid] < nums[end]) {
                        return nums[begin];
                    } else {
                        begin = mid;
                    }
                }
            }
            return nums[end];
        }
    }

}
