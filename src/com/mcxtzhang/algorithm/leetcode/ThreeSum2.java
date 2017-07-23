package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Intro:iven an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/22.
 * History:
 */
public class ThreeSum2 {
    public static void main(String[] args) {
        //int[] nums = new int[]{-4, -1, -1, 0, 1, 2};
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        System.out.println("结果是:");
        for (List<Integer> list : lists) {
            System.out.println("分割线");
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
/*        String a = 1 + "" + 2 + "" + 3;
        String b = 1 + "" + 2 + "" + 3;

        System.out.println(a == b);
        System.out.println(a);
        System.out.println(b);*/
    }

    public static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) return result;
            List<List<Integer>> temp = null;
            List<Integer> toBeAddedList;
            int[] toBeSort = new int[3];
            Map<String, Boolean> map = new HashMap<>();

            Boolean isExist;
            for (int i = 0; i < nums.length; i++) {
                temp = twoSum(nums, -nums[i], i);
                if (temp != null && !temp.isEmpty()) {
                    for (List<Integer> item : temp) {
                        toBeSort[0] = nums[i];
                        toBeSort[1] = nums[item.get(0)];
                        toBeSort[2] = nums[item.get(1)];
                        sort(toBeSort);
                        String tempKey = toBeSort[0] + "" + toBeSort[1] + "" + toBeSort[2];
                        isExist = map.get(tempKey);
                        if (!Boolean.TRUE.equals(isExist)) {
                            map.put(tempKey, true);
                            toBeAddedList = new ArrayList<>();
                            toBeAddedList.add(toBeSort[0]);
                            toBeAddedList.add(toBeSort[1]);
                            toBeAddedList.add(toBeSort[2]);
                            result.add(toBeAddedList);
                        }
                    }
                }
            }
            return result;
        }

        public static void sort(int[] nums) {
            if (nums == null) return;
            int temp;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                    }
                }
            }
        }


        public static List<List<Integer>> twoSum(int[] nums, int s, int ignoreIndex) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> ontResult;
            if (nums == null || nums.length < 2) return result;

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (i != ignoreIndex) {
                    map.put(nums[i], i);
                }
            }
            int temp = 0;
            Integer otherNum;
            for (int i = 0; i < nums.length; i++) {
                if (i != ignoreIndex) {
                    temp = s - nums[i];
                    otherNum = map.get(temp);
                    if (otherNum != null && otherNum > i) {
                        ontResult = new ArrayList<>();
                        ontResult.add(i);
                        ontResult.add(otherNum);
                        result.add(ontResult);
                    }
                }
            }
            return result;
        }
    }
}
