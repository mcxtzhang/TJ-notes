package com.mcxtzhang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Intro: 581. Shortest Unsorted Continuous Subarray
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.

 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/30.
 * History:
 */
public class Test581 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 2};
        new Solution().findUnsortedSubarray(nums);
    }

    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            //用一个 o N的空间，存放数组备份，排序，寻找头尾第一处不一样的地方，相减得到结果
            int[] copy = nums.clone();
            Arrays.sort(copy);
            int begin = -1 ;
            for(int i=0;i<nums.length;i++){
                if(nums[i] != copy[i]){
                    begin = i;
                    break;
                }
            }
            //有序
            if(begin == -1) return 0;

            int end = begin+1;
            for(int i=nums.length-1;  i>=end ;i--){
                if(nums[i] != copy[i]){
                    end = i;
                    break;
                }
            }


            return end - begin +1;




        }
    }






// class Solution {//考虑只有一组数字逆序，即 1 2 4 3 5 6 , 这样 begin 是 2， end是3 pass
//     public int findUnsortedSubarray(int[] nums) {
//         //头尾两个指针，分别遍历，  尾指针的结束条件要是头指针的位置。 记录两个index，相减 得到结果
//         int begin = -1;
//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i]> nums[i+1]){
//                 //要考虑重复的数字，比如  1 2 2 3 2 2
//                 while(i!=0 && nums[i] == nums[i-1]){
//                     i--;
//                 }
//                 begin = i;
//                 break;
//             }
//         }
//         //本身已经有序
//         if(begin==-1 )return 0;
//         int end = -1;
//         for(int i=nums.length-1;i>begin;i--){
//             if(nums[i-1]>nums[i]){
//                 //要考虑重复的数字，比如  1 2 2 3 2 2
//                 while(i!=nums.length-1 && nums[i] == nums[i+1]){
//                     i++;
//                 }
//                 end = i;
//                 break;
//             }
//         }
//         return end-begin+1;
//     }
// }

}
