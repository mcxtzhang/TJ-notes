package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: 414. Third Maximum Number
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.


 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/11/11.
 * History:
 */
public class Test414 {
    class Solution {
        public int thirdMax(int[] nums) {
            if(null == nums || nums.length<1) return -1;
            //考虑数组里的元素本身就是int类型的最小值
            long max1 = Long.MIN_VALUE;
            long max2 = Long.MIN_VALUE;
            long max3 = Long.MIN_VALUE;

            for(int i:nums){
                if(i>max1){
                    max3 = max2;
                    max2= max1;
                    max1= i;
                    //&& 后面的条件是为了防止数组里有重复的元素
                }else if (i>max2 && i<max1){
                    max3 = max2;
                    max2 = i;
                }else if(i>max3 && i<max2){
                    max3 = i;
                }
            }

            return max3==Long.MIN_VALUE?(int)max1:(int)max3;


        }
    }
}
