package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Intro: 56. Merge Intervals
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/20.
 * History:
 */
public class Test56_MergeIntervals {

    public static void main(String[] args) {
        List<Interval> temp = new LinkedList<>();
        temp.add(new Interval(0, 4));
        temp.add(new Interval(1, 4));

        new Solution().merge(temp);
    }

    static public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * Definition for an interval.
     * public class Interval {
     * int start;
     * int end;
     * Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; }
     * }
     */
    static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (null == intervals || intervals.size() < 2) return intervals;
            intervals = quickSort(intervals);
            List<Interval> result = new LinkedList<>();
            Interval pre = intervals.get(0), now;
            for (int i = 1; i < intervals.size(); i++) {
                now = intervals.get(i);
                if (pre.start <= now.start && pre.end >= now.start && pre.end <= now.end) {//相交
                    pre = new Interval(pre.start, now.end);
                } else if (pre.start >= now.start && pre.end <= now.end) {//包括
                    pre = now;
                } else if (pre.start <= now.start && pre.end >= now.end) {

                } else {
                    result.add(pre);
                    pre = now;
                }
                if (i == intervals.size() - 1) {
                    result.add(pre);
                }
            }
            return result;
        }

        public List<Interval> quickSort(List<Interval> intervals) {
            if (null == intervals) return null;
            Object[] objects = intervals.toArray();
            quickSort(objects, 0, objects.length - 1);
            List<Interval> res = new ArrayList<>(objects.length);
            for (Object object : objects) {
                res.add((Interval) object);
            }
            return res;
        }

        //按照下标排序
        public void quickSort(Object[] nums, int begin, int end) {
            if (nums == null || begin < 0 || end < 0 || begin > nums.length - 1 || end > nums.length - 1 || begin >= end)
                return;

            int l = begin, r = end;
            Interval temp = (Interval) nums[l];
            while (l < r) {
                while (l < r && temp.start <= ((Interval)nums[r]).start) {
                    r--;
                }
                if (l < r) {
                    nums[l] = nums[r];
                    l++;
                }

                while (l < r && temp.start >= ((Interval)nums[l]).start) {
                    l++;
                }
                if (l < r) {
                    nums[r] = nums[l];
                    r--;
                }
            }
            nums[l] = temp;
            quickSort(nums, begin, l - 1);
            quickSort(nums, l + 1, end);

        }


    }


}
