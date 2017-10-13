package com.mcxtzhang.algorithm.leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Intro:Find All Numbers Disappeared in an Array
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/13.
 * History:
 */
public class Test448 {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new LinkedList<>();
            //解法1  用 on的空间
            if(null == nums || nums.length <1) return result;
            int len = nums.length;
            int[] temp = new int[len];
            for(int i=0;i<len;i++){
                temp[nums[i]-1]=1;
            }

            for(int i=0;i<len;i++){
                if(temp[i]!=1){
                    result.add((i+1));
                }
            }
            return  result;

        }
    }


    class Solution2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new LinkedList<>();
            //解法2  在原来的数组 将 元素放置在正确的位置上，再次遍历，如果位置不正确 就是空缺的
            if(null == nums || nums.length <1) return result;
            int len = nums.length;

            for(int i=0;i<len;i++){
                int val = nums[i];
                while(  nums[val-1] !=val   ){
                    int temp = nums[val-1];
                    nums[val-1] = val;
                    val = temp;
                }
            }

            for(int i=0;i<len;i++){
                if(nums[i]!= i+1){
                    result.add(i+1);
                }
            }

            return  result;





        }
    }

}
