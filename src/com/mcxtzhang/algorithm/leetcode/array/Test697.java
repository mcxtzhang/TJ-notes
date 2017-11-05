package com.mcxtzhang.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 697. Degree of an Array
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 Note:

 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.



 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/11/5.
 * History:
 */
public class Test697 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            //用map缓存，分别以数字元素为key，value缓存最小的下标，最大的下标，和出现的次数
            if (null == nums || nums.length < 1) return 0;
            Map<Integer, Integer> count = new HashMap<>();
            Map<Integer, Integer> begin = new HashMap<>();
            Map<Integer, Integer> end = new HashMap<>();
            int maxCount =0 ;

            Integer temp;
            for (int i = 0; i < nums.length; i++) {
                //第一次
                if(!count.containsKey(nums[i])){
                    count.put(nums[i],1);
                    begin.put(nums[i],i);
                    end.put(nums[i],i);
                }else{
                    count.put(nums[i],  count.get(nums[i])+1 );
                    end.put(nums[i],i);
                }
                maxCount = Math.max(maxCount,count.get(nums[i]));

            }
            //遍历count map，如果count 等于maxCount，计算他的begin end 的差值，同时取差值的最小值

            int result = Integer.MAX_VALUE;
            Set<Map.Entry<Integer, Integer>> countSet = count.entrySet();
            for (Map.Entry<Integer, Integer> entry : countSet) {
                int value = entry.getValue();
                if (value == maxCount) {
                    result = Math.min(result,   end.get(entry.getKey())   -  begin.get(entry.getKey())+1 );
                }
            }

            return result;
        }
    }
}
