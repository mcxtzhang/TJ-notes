package com.mcxtzhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Intro:
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/23.
 * History:
 */
public class Test78_Subsets {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (null == nums || nums.length < 1) return result;

            subsetsHelper(nums, 0, result, new LinkedList<Integer>());
            return result;
        }

        public void subsetsHelper(int[] nums, int begin, List<List<Integer>> results, List<Integer> temp) {
            results.add(new ArrayList(temp));
            for (int i = begin; i < nums.length; i++) {
                temp.add(nums[i]);

                subsetsHelper(nums, i + 1, results, temp);

                temp.remove(temp.size() - 1);
            }


        }
    }
}
