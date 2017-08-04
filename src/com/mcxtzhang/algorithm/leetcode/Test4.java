package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:  Median of Two Sorted Arrays
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/2.
 * History:
 */
public class Test4 {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};
        new Solution3().findMedianSortedArrays(a, b);
    }


    public static class Solution3 {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) return 0;

            double result = 0;
            int target = -1;
            int target2 = -1;
            if (((nums1.length + nums2.length) & 0x01) == 0x01) {
                target = (nums1.length + nums2.length) / 2;
            } else {
                target2 = (nums1.length + nums2.length) / 2;
                target = target2 - 1;
            }

            int i = 0, j = 0, k = 0;
            while (i < nums1.length || j < nums2.length) {
                if ((i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) || (j >= nums2.length)) {
                    if (k == target) {
                        result = nums1[i];
                    }
                    if (k == target2) {
                        result = (result + nums1[i]) / 2.0;
                    }
                    i++;
                } else {
                    if (k == target) {
                        result = nums2[j];
                    }
                    if (k == target2) {
                        result = (result + nums2[j]) / 2.0;
                    }
                    j++;
                }
                k++;
            }
            return result;
        }
    }


    //beats 88%
    public static class Solution2 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) return 0;

            double result = 0;
            int target = -1;
            int target2 = -1;
            if (((nums1.length + nums2.length) & 0x01) == 0x01) {
                target = (nums1.length + nums2.length) / 2;
            } else {
                target2 = (nums1.length + nums2.length) / 2;
                target = target2 - 1;
            }

            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length) {


                if (nums1[i] < nums2[j]) {
                    if (k == target) {
                        result = nums1[i];
                    }
                    if (k == target2) {
                        result = (result + nums1[i]) / 2.0;
                    }

                    i++;
                } else {
                    if (k == target) {
                        result = nums2[j];
                    }

                    if (k == target2) {
                        result = (result + nums2[j]) / 2.0;
                    }


                    j++;
                }
                k++;
            }

            while (i < nums1.length) {
                if (k == target) {
                    result = nums1[i];
                }
                if (k == target2) {
                    result = (result + nums1[i]) / 2.0;
                }

                i++;
                k++;
            }

            while (j < nums2.length) {
                if (k == target) {
                    result = nums2[j];
                }

                if (k == target2) {
                    result = (result + nums2[j]) / 2.0;
                }

                j++;
                k++;
            }

            return result;

        }
    }


    //方法一 最慢 无法通过
    public static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) return 0;

            int[] mergeArray = new int[nums1.length + nums2.length];
            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    mergeArray[k++] = nums1[i++];
                } else {
                    mergeArray[k++] = nums2[j++];
                }
            }

            while (i < nums1.length) {
                mergeArray[k++] = nums1[i++];
            }

            while (j < nums2.length) {
                mergeArray[k++] = nums2[j++];
            }
            int temp = (mergeArray.length - 1);
            if ((temp & 0x01) == 0x01) {
                return (float) (mergeArray[temp / 2] + mergeArray[temp / 2 + 1]) / 2;
            } else {
                return mergeArray[temp / 2];
            }

        }
    }
}
