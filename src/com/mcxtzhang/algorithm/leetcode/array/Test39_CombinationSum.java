package com.mcxtzhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Intro: 39. Combination Sum
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/25.
 * History:
 */
public class Test39_CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // 分治法，将target 分解成一个一个小问题
            List<List<Integer>> results = new ArrayList<>();
            if (null == candidates || candidates.length < 1) return results;
            List<Integer> temp = new LinkedList<>();
            helper(candidates, 0, target, temp, results);
            return results;
        }

        //为了去重，原则上 选择的数 要大于等于上一个，所以加一个 起始index
        public void helper(int[] nums, int begin, int target, List<Integer> temp, List<List<Integer>> results) {
            int len = nums.length;
            for (int i = begin; i < len; i++) {
                if (target == nums[i]) {
                    temp.add(target);
                    results.add(new ArrayList(temp));
                    temp.remove(temp.size() - 1);
                } else if (target > nums[i]) {
                    temp.add(nums[i]);
                    helper(nums, i, target - nums[i], temp, results);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
