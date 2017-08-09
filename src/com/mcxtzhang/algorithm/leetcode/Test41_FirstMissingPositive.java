package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/9.
 * History:
 */
public class Test41_FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        int i = new Solution().firstMissingPositive(nums);
        System.out.println(i);

        nums = new int[]{1, 2, 0};
        i = new Solution().firstMissingPositive(nums);
        System.out.println(i);

        nums = new int[]{3, 4, 1, -1};
        i = new Solution().firstMissingPositive(nums);
        System.out.println(i);
    }

    public static class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null) return -1;
            //统统 将原本所在位置 -1
            //合格的数 放在它应该在的位置上，
            // 不合格的数
            //不合格： 负数，大于数组长度的数，重复也可以忽略 ,重复会造成死循环
            int temp;
            for (int i = 0; i < nums.length; i++) {
                temp = nums[i];
                if (i != temp - 1) {
                    nums[i] = -1;//不合格先-1 然后放在它应该在的位置上
                    if (temp - 1 < nums.length && temp > 0 && nums[temp - 1] != temp) {
                        int toBeReplace = nums[temp - 1];
                        while (toBeReplace - 1 < nums.length && toBeReplace > 0 && nums[temp - 1] != temp) {
                            nums[temp - 1] = temp;
                            temp = toBeReplace;
                            toBeReplace = nums[temp - 1];
                        }
                        nums[temp - 1] = temp;
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }
}
