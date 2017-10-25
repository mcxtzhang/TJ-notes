package com.mcxtzhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Intro:
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/25.
 * History:
 */
public class Test40_CombinationSum2 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            // 分治法，将target 分解成一个一个小问题
            List<List<Integer>> results = new ArrayList<>();
            if (null == candidates || candidates.length < 1) return results;
            List<Integer> temp = new LinkedList<>();
            //排序 去重
            Arrays.sort(candidates);
            //int duplicateCount = removeDuplicate(candidates);

            helper(candidates, 0, candidates.length - 1, target, temp, results);
            return results;
        }

        //原则上 选择的数 要大于上一个， 因为数字不能重复
        public void helper(int[] nums, int begin, int end, int target, List<Integer> temp, List<List<Integer>> results) {

            for (int i = begin; i <= end; i++) {
                //也是考虑去重
                if (i == begin || nums[i] != nums[i - 1]) {


                    if (target == nums[i]) {
                        temp.add(target);
                        results.add(new ArrayList(temp));
                        temp.remove(temp.size() - 1);
                    } else if (target > nums[i]) {

                        temp.add(nums[i]);
                        helper(nums, i + 1, end, target - nums[i], temp, results);
                        temp.remove(temp.size() - 1);


                    }

                }
            }
        }


        public int removeDuplicate(int[] nums) {
            int index = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[index]) {
                    nums[++index] = nums[i];
                }
            }
            return nums.length - 1 - index;

        }
    }
}
