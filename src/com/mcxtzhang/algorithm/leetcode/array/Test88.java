package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro:  88. Merge Sorted Array
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * <p>
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/22.
 * History:
 */
public class Test88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,0};
        int[] nums2 = new int[]{2};
        new Solution().merge(nums1,1,nums2,1);
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if(nums1 == null || nums1.length< m+n|| nums2==null) return ;
            merge(nums1,m-1,nums2,n-1,m+n-1);
        }

        //从尾至头排列，依次从大到小排列。 依次比较数组当前元素，大的放最后，递归
        public void merge(int[] nums1,int b1,int[] nums2,int b2, int index){
            if(index <0) return;
            if(b1<0){
                // 依次放置nums2的即可
                for(;b2>=0;b2--){
                    nums1[index--] = nums2[b2];
                }
                return ;
            }
            if(b2<0){
                //依次放置nums1 不用修改
                return ;
            }
            if(nums1[b1]>nums2[b2]){
                nums1[index--]=nums1[b1--];
            }else{
                nums1[index--]=nums2[b2--];
            }
            merge(nums1,b1,nums2,b2,index);
        }
    }
}
