package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro:167. Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2



 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/16.
 * History:
 */
public class Test167 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            //从头尾分别遍历
            int[] result = new int[2];
            if(null == numbers || numbers.length <1) return result;
            int l = 0;
            int r = numbers.length-1;

            while(l<r){
                if(numbers[l]+numbers[r]==target){
                    result[0] = l+1;
                    result[1] = r+1;
                    return result;
                }else if(numbers[l] + numbers[r] >target){
                    r--;
                }else{
                    l++;
                }


            }
            return result;


        }
    }

}
