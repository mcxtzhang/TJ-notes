package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: 189. Rotate Array
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * [show hint]
 * <p>
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/18.
 * History:
 */
public class Test189 {
    class Solution3 {
        public void rotate(int[] nums, int k) {
            if(nums == null || nums.length<1 || k<=0) return ;
            int len = nums.length;
            //先修正K 以防超过length
            k = k%len;
            if(k==0) return;

            //解法4 利用 o(n)的空间 将数组首尾拼接
            int[] temp = new int[len*2];
            System.arraycopy(nums,0,temp,0,len);
            System.arraycopy(nums,0,temp,len,len);
            System.arraycopy(temp,  len -k ,nums,0,len);
        }

    }

    class Solution2 {
        public void rotate(int[] nums, int k) {
            if(nums == null || nums.length<1 || k<=0) return ;
            int len = nums.length;
            //先修正K 以防超过length
            k = k%len;
            if(k==0) return;
            //解法3 旋转字符类似的思想 先将数组整个旋转， 然后再局部旋转 以[0,k) 和[k,len) 分界线
            reverseArray(nums,0,len-1);
            reverseArray(nums,0,k-1);
            reverseArray(nums,k,len-1);
        }
        //反转数组的局部部分
        public void reverseArray(int[] nums,int begin,int end){
            int mid = (begin + end )>>>1;
            int count = mid - begin;
            for(int i = 0 ;i<=count ;i++){
                int temp = nums[begin+i];
                nums[begin+i] = nums[end-i];
                nums[end-i] = temp;
            }
        }
    }


    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length < 1 || k <= 0) return;
            int len = nums.length;
            //先修正K 以防超过length
            k = k % len;
            if (k == 0) return;


            //解法1 用一个新数组 O(n)空间复杂度
            //解法2 在原数组上，旋转k次
            for (int i = 1; i <= k; i++) {
                int temp = nums[len - 1];
                //注意这里不要越界
                System.arraycopy(nums, 0, nums, 1, len - 1);
                nums[0] = temp;
            }


        }
    }


}
