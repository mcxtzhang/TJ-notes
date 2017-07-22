package com.mcxtzhang.algorithm.offer;


import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 和为S的两个数字
 * 在一个递增排序的数组和一个数字s。
 * 在数组中查找两个数，
 * 使得他们的和正好是s。
 * 如果有多对数字的和为s，输出任意一对即可.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/22.
 * History:
 */
public class Test41 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 7, 11, 15};
        List<Integer> integers = twoSum(nums, 15);
        System.out.println("15结果是:");
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        integers = twoSum(nums, 16);
        System.out.println("16结果是:");
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        integers = twoSum(nums, -100);
        System.out.println("-100结果是:");
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static List<Integer> twoSum(int[] nums, int s) {
        List<Integer> list = new ArrayList<>(2);
        if (nums == null || nums.length < 2) return list;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == s) {
                list.add(nums[left]);
                list.add(nums[right]);
                break;
            } else if (nums[left] + nums[right] < s) {
                left++;
            } else {
                right--;
            }
        }

        return list;
    }
}
