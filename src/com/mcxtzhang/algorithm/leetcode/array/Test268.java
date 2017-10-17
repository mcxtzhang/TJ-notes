package com.mcxtzhang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Intro: 268. Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/17.
 * History:
 */
public class Test268 {
    class Solution2 {
        public int missingNumber(int[] nums) {
            if(null == nums || nums.length<1) return -1;
            //解法二 观察题目，  数组长度为n，包含了 0~n ,这n+1 个元素中缺少一个元素，
            //则求出缺少的元素就是利用 数组累加和，与 0+.............n的和之差
            //数学建模的魅力
            int len = nums.length;
            int sum = (int)((0+ len )* (len+1)*1.0f/2) ;

            int temp = 0;
            for(int i :nums){
                temp+=i;
            }
            return sum-temp;


        }
    }



    class Solution {
        public int missingNumber(int[] nums) {
            if(null == nums || nums.length<1) return -1;
            //排序
            Arrays.sort(nums);

            int len = nums.length;
            //遍历 找到缺口
            for(int i=0;i<len;i++){
                if(nums[i]!=i){
                    return i;
                }
            }
            //如果没找到缺口，则缺口就是最后一个元素+1
            return nums[len-1]+1;
        }
    }
}
