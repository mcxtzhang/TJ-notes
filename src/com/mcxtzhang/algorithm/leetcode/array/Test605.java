package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: 605. Can Place Flowers
 * <p>
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/11/9.
 * History:
 */
public class Test605 {
    class Solution {
        public boolean canPlaceFlowers(int[] nums, int n) {
            //思路 模拟一遍放置的过程
            if(null == nums || nums.length<0 || n<0) return false;
            if(n==0) return true;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    boolean plant = true;
                    if(i>0){
                        //查看左边是否种过花
                        if(nums[i-1]==1){
                            continue;
                        }
                    }
                    if(i<nums.length-1){
                        if(nums[i+1] ==1){
                            continue;
                        }
                    }
                    //说明左右都没有花
                    nums[i] = 1;
                    n--;
                    if(n==0)break;
                }
            }
            return n==0;
        }
    }
}
