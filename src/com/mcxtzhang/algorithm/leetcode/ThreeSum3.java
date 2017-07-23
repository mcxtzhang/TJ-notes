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
public class ThreeSum3 {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, -1, 0, 1, 2};
        //int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        //nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        nums = new int[]{-1, 0, 1, 2, -1, -4};


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
            //先排序。 因为 输出的结果 都是排序后的数组
            quickSort(nums, 0, nums.length - 1);


            List<List<Integer>> temp = null;
            List<Integer> toBeAddedList;
            Map<String, Boolean> map = new HashMap<>();
            Boolean isExist;
            for (int i = 0; i < nums.length; i++) {
                temp = twoSum(nums, -nums[i], i);
                if (temp != null && !temp.isEmpty()) {
                    for (List<Integer> item : temp) {
                        String tempKey = nums[i] + "" + item.get(0) + "" + item.get(1);
                        isExist = map.get(tempKey);
                        if (!Boolean.TRUE.equals(isExist)) {
                            map.put(tempKey, true);
                            toBeAddedList = new ArrayList<>();
                            toBeAddedList.add(nums[i]);
                            toBeAddedList.add(item.get(0));
                            toBeAddedList.add(item.get(1));
                            result.add(toBeAddedList);
                        }
                    }
                }
            }
            return result;
        }

        /**
         * 快速排序
         */
        public static void quickSort(int[] src, int begin, int end) {
            if (src == null || begin < 0 || end < 0 || begin >= src.length || end >= src.length || begin >= end)
                return;
            int l = begin;
            int r = end;
            int temp = src[l];
            while (l < r) {
                while (l < r && temp <= src[r]) {
                    r--;
                }
                if (l < r) {
                    src[l] = src[r];
                    l++;
                }
                while (l < r && temp >= src[l]) {
                    l++;
                }
                if (l < r) {
                    src[r] = src[l];
                    r--;
                }
            }
            src[l] = temp;
            quickSort(src, begin, l - 1);
            quickSort(src, l + 1, end);
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
                if (i > ignoreIndex) {
                    temp = s - nums[i];
                    otherNum = map.get(temp);
                    if (otherNum != null && otherNum > i) {
                        ontResult = new ArrayList<>();
                        ontResult.add(nums[i]);
                        ontResult.add(nums[otherNum]);
                        result.add(ontResult);
                    }
                }
            }
            return result;
        }
    }
}
