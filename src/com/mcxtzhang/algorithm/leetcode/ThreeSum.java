package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

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
public class ThreeSum {
    public static void main(String[] args) {
        //int[] nums = new int[]{-4, -1, -1, 0, 1, 2};
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println("结果是:");
        for (List<Integer> list : lists) {
            System.out.println("分割线");
            for (Integer integer : list) {
                System.out.println(integer);
            }


        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        //step1 sort
        quickSort(nums,0,nums.length-1);

        //step2 pickout result
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = twoSum(nums, -nums[i], i);
            if (!temp.isEmpty()) {
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void quickSort(int[] nums, int begin, int end) {
        if (nums == null || nums.length < 2 || begin >= end || end - begin < 2) return;
        int left = begin;
        int right = end;
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            if (nums[right] < temp) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= temp) {
                left++;
            }
            if (nums[left] > temp) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = temp;
        quickSort(nums, begin, left - 1);
        quickSort(nums, left + 1, end);


    }


    public static List<Integer> twoSum(int[] nums, int s, int ignoreIndex) {
        List<Integer> list = new ArrayList<>(2);
        if (nums == null || nums.length < 2) return list;
        int left = 0;
        int right = nums.length - 1;
        while (left < right && left != ignoreIndex && right != ignoreIndex) {
            if (nums[left] + nums[right] == s) {
                list.add(nums[left]);
                list.add(nums[right]);
                break;
            } else if (nums[left] + nums[right] < s) {
                left++;
            } else {
                right--;
            }
        }

        return list;
    }
}
