package com.mcxtzhang.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Intro:217. Contains Duplicate
 * <p>
 * Given an array of integers, find if the array contains any duplicates. Y
 * our function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/17.
 * History:
 */
public class Test217 {
    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            if(null == nums || nums.length <1) return false;
            //方法2 排序 依次遍历
            Arrays.sort(nums);
            int len = nums.length;
            for(int i=1;i<len;i++){
                if(nums[i]==nums[i-1]){
                    return true;
                }
            }
            return false;
        }
    }


    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if(null == nums || nums.length <1) return false;
            //方法1 用 O(n)的空间 做哈希表
            Map<Integer,Integer> map =new HashMap<>();
            for(int i:nums){
                if(map.get(i)==null){
                    map.put(i,1);
                }else{
                    map.put(i,2);
                }
            }

            Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer,Integer> entry = iterator.next();
                if(entry.getValue()==2){
                    return true;
                }
            }
            return false;


        }
    }



}
