package com.mcxtzhang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Intro: 169. Majority Element
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/16.
 * History:
 */
public class Test169 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 0, 0, 0, 2};
        new Solution().majorityElement(nums);
    }


    class Solution2 {
        public int majorityElement(int[] nums) {
            int count = 1;
            int lastNum = nums[0];
            int len  = nums.length;
            for(int i=1;i<len;i++){
                if(nums[i]!=lastNum){
                    count=count -1;
                    if(count<0){
                        count = 1;
                        lastNum = nums[i];
                    }


                }else{
                    count ++;
                }
            }

            return lastNum;
        }


    }


    static class Solution {
        public int majorityElement(int[] nums) {
            //快速排序的思想，如果排好序的元素正好是n/2 则找到了

            //return findMajorityElement(nums,0,nums.length-1);
            Arrays.sort(nums);
            return nums[nums.length/2];

        }

        public int findMajorityElement(int[] nums,int b,int e){
            if(nums == null || nums.length<1 || b<0 || e<0 || b>e ||b>nums.length || e>nums.length ) return -1;

            int l = b;
            int r = e;
            int temp = nums[l];

            while(l<r){

                while(l<r && nums[r]>=temp){
                    r--;
                }
                if(l<r){
                    nums[l] = nums[r];
                    l++;
                }

                while(l<r && nums[l] <=temp){
                    l++;
                }

                if(l<r){
                    nums[r]=nums[l];
                    r--;
                }
            }

            nums[l] = temp;
            if(l==nums.length/2) return nums[l];

            if(l<nums.length/2) return findMajorityElement(nums,l+1,e);

            return findMajorityElement(nums,b,l-1);

        }
    }
}
