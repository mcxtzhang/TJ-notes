package com.mcxtzhang.algorithm.other;

/**
 * Intro: 实现一个函数，找出数组中差的绝对值最小的两个元素，要求时间复杂度为线性时间
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/25.
 * History:
 */
public class FindMinGapTest {
    public static void main(String[] args) {
        //int[] nums = new int[]{5, 4, 1, 3, 9, 52, 60};
        //int[] nums = new int[]{1, 1, 1, 1, 9, 52, 60};
        int[] nums = new int[]{-1, 0, 2, 3, 9, 52, 60};
        int[] minGapInArray = findMinGapInArray(nums);
        for (int i : minGapInArray) {
            System.out.println(i);
        }
    }

    public static int[] findMinGapInArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        //先遍历一遍找到范围，然后用辅助数组存放这些元素，找到间隔0最小的两个元素
        int bottom = nums[0], top = bottom;

        for (int num : nums) {
            bottom = Math.min(num, bottom);
            top = Math.max(top, num);
        }

        int[] temp = new int[top - bottom + 1];
        for (int num : nums) {
            if (temp[num - bottom] == 0) {
                temp[num - bottom] = 1;
            } else {
                temp[num - bottom] = -1;
            }
        }

        int left = 0, right = 0, gap = Integer.MAX_VALUE;
        int lastI = 0, tempGap = 0;
        for (int index = 0; index < temp.length; index++) {
            int i = temp[index];
            if (i == 1) {//有值
                if (lastI == 0) {//还没出现过非0数字
                    lastI = index + bottom;
                    tempGap = 0;
                    continue;
                } else {
                    if (tempGap < gap) {//找到最小间距
                        left = lastI;
                        right = index + bottom;
                        gap = tempGap;
                    }
                    tempGap = 0;
                    lastI = index + bottom;
                    continue;
                }
            } else if (i == -1) {
                //重复的 间距为0
                return new int[]{index + bottom, index + bottom};
            } else {
                tempGap++;
            }
        }

        return new int[]{left, right};

    }
}
