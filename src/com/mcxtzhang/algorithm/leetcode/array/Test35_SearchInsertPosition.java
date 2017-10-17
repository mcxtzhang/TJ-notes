package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/15.
 * History:
 */
public class Test35_SearchInsertPosition {
    public class Solution {
        public int searchInsert(int[] nums, int target) {
            if(null==nums || nums.length<1) return 0;

            int l = 0;
            int r = nums.length-1;
            int m ;
            while(l<=r){
                m = (l+r)>>>1;
                if(nums[m]==target){
                    return m;
                }else if(nums[m]>target){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
            return l;

        }
    }
}
