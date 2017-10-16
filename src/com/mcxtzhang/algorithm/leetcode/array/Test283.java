package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/16.
 * History:
 */
public class Test283 {

    //解法二 更6
    class Solution2 {
        public void moveZeroes(int[] nums) {
            //先遍历 找出0的count
            //再遍历，将非0元素放置到数组前面，后面补0
            if(null == nums || nums.length <1) return ;
            int count = 0;
            int len = nums.length;
            for(int i=0;i<len;i++){
                if(nums[i]==0)count++;
                else{
                    nums[i-count]=nums[i];

                }
            }

            //append 0
            for(int i=len-count;i<len;i++){
                nums[i] = 0;
            }




        }
    }


    class Solution {
        public void moveZeroes(int[] nums) {
            //先遍历 找出0的count
            //再遍历，将非0元素放置到数组前面，后面补0
            if(null == nums || nums.length <1) return ;
            int count = 0;
            int len = nums.length;
            for(int i=0;i<len;i++){
                if(nums[i]==0)count++;
            }
            //move elements
            int valIndex = 0;
            int noZeroCount = 0;
            for(int i=0;i<len;i++){
                if(nums[i]==0)continue;
                noZeroCount ++;
                nums[valIndex++] = nums[i];
                if(noZeroCount + count == len)break;
            }
            //append 0
            for(int i=len-count;i<len;i++){
                nums[i] = 0;
            }




        }
    }
}
