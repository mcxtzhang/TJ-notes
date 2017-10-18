package com.mcxtzhang.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Intro:219. Contains Duplicate II
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/18.
 * History:
 */
public class Test219 {


    //39%
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            //解法1 借助哈希表
            if (nums == null || nums.length < 1) return false;
            Map<Integer, Integer> map = new HashMap<>();
            int len = nums.length;
            Integer temp;
            for (int i = 0; i < len; i++) {
                temp = map.get(nums[i]);
                if (temp == null) {
                    map.put(nums[i], i);
                } else {
                    if (i - temp <= k) {
                        return true;
                    } else {
                        map.put(nums[i], i);
                    }
                }
            }
            return false;


        }
    }
}
