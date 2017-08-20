package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Intro:
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/10.
 * History:
 */
public class Test46_Permutations {
    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 3};
        List<List<Integer>> permute = new Solution3().permute(temp);
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }


        int[] shuzu = new int[]{1, 2};
        shuzu[0] ^= shuzu[1];
        shuzu[1] ^= shuzu[0];
        shuzu[0] ^= shuzu[1];
        for (int i : shuzu) {
            System.out.println(i);
        }


        int a = 1;
        int b = 2;
        a ^= b;
        b ^= a;
        a ^= b;


        System.out.println(a + "\t" + b);
    }

    //201708020
    static class Solution3 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            if (null == nums || nums.length < 1) return result;

            permuteSegment(nums, 0, result);
            return result;

        }


        public void permuteSegment(int[] nums, int begin, List<List<Integer>> result) {
            if (begin < 0 || begin > nums.length - 1 || result == null) return;
            // end
            if (begin == nums.length - 1) {
                List<Integer> temp = new LinkedList<>();
                for (int i = 0; i < nums.length; i++) {
                    temp.add(nums[i]);
                }
                result.add(temp);
                return;
            }
            permuteSegment(nums, begin + 1, result);

            //mid
            for (int i = begin + 1; i < nums.length; i++) {
                swap(nums, i, begin);
                permuteSegment(nums, begin + 1, result);
                swap(nums, begin, i);
            }
        }

        public void swap(int[] nums, int l, int r) {
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l] ^= nums[r];
        }
    }


    public class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null) return result;
            permuteHelper(nums, 0, result);
            return result;
        }

        private void permuteHelper(int[] src, int begin, List<List<Integer>> result) {
            if (src == null) return;
            if (begin == src.length - 1) {
                result.add(newList(src));
            } else {
                permuteHelper(src, begin + 1, result);
                for (int i = begin + 1; i < src.length; i++) {
                    swap(src, begin, i);
                    permuteHelper(src, begin + 1, result);
                    swap(src, i, begin);
                }
            }
        }

        private void swap(int[] src, int a, int b) {
            int temp = src[a];
            src[a] = src[b];
            src[b] = temp;
        }

        private List<Integer> newList(int[] src) {
            List<Integer> result = new ArrayList<>();
            for (int i : src) {
                result.add(i);
            }
            return result;
        }

    }


    //only beats 22%
    public class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null) return result;

            List<Integer> src = new ArrayList<>();
            for (int num : nums) {
                src.add(num);
            }
            append(src, new ArrayList<>(), result);
            return result;
        }

        public void append(List<Integer> src, List<Integer> item, List<List<Integer>> result) {
            if (src == null || src.isEmpty()) return;
            for (Integer integer : src) {
                item.add(integer);
                if (src.size() == 1) {
                    result.add(newList(item));
                } else {
                    append(newList(src, integer), item, result);
                }
                item.remove(item.size() - 1);
            }


        }

        private List<Integer> newList(List<Integer> src, Integer tobeDelete) {
            List<Integer> list = new ArrayList<>();
            for (Integer integer : src) {
                if (integer != tobeDelete) {
                    list.add(integer);
                }
            }
            return list;
        }

        private List<Integer> newList(List<Integer> src) {
            List<Integer> list = new ArrayList<>();
            for (Integer integer : src) {
                list.add(integer);
            }
            return list;
        }
    }
}
