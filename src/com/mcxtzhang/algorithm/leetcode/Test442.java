package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/17.
 * History:
 */
public class Test442 {
    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        input = new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        List<Integer> duplicates = new Solution2().findDuplicates(input);
        for (Integer duplicate : duplicates) {
            System.out.println(duplicate);
        }
    }

    public static class Solution2 {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length < 1) return result;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1 && nums[i] != -1) {
                    if (nums[nums[i] - 1] == nums[i]) {
                        nums[nums[i] - 1] = -1;//重复
                    } else if (nums[nums[i] - 1] == -1) {

                    } else {
                        swap(nums, nums[i] - 1, i);
                        i--;
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) {
                    result.add(i + 1);
                }
            }
            return result;
        }

        public void swap(int[] nums, int l, int r) {
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l] ^= nums[r];
        }
    }


    /**
     * Input:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * Output:
     * [2,3]
     */
    public static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length < 1) return result;
            for (int i = 0; i < nums.length; i++) {
                int j = i;
                while (nums[j] != (j + 1) && nums[j] != -1 && nums[nums[j] - 1] != -1) {
                    //move
                    if (nums[nums[j] - 1] != nums[j]) {
                        swap(nums, nums[j] - 1, j);
                    } else {
                        nums[nums[i] - 1] = -1;
                        break;
                    }
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) {
                    result.add(i + 1);
                }
            }
            return result;
        }

        public void swap(int[] nums, int l, int r) {
            nums[l] = nums[l] ^ nums[r];
            nums[r] = nums[r] ^ nums[l];
            nums[l] = nums[l] ^ nums[r];
        }
    }

}
