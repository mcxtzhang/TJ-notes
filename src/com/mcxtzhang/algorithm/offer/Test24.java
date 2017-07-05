package com.mcxtzhang.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 二叉搜索树的后续遍历序列
 * 输入一个整数数组，判断该数组是不是 某个二叉搜索树 的 后序遍历序列的结果。
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/5.
 * History:
 */
public class Test24 {
    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] b = new int[]{7, 4, 6, 5};
        System.out.println(isTree(a));
        System.out.println(isTree(b));
    }

    public static boolean isTree(int[] order) {
        if (order == null) return false;
        List<Integer> list = new ArrayList<>();
        for (int i : order) {
            list.add(i);
        }
        return isTree(list);
    }

    public static boolean isTree(List<Integer> order) {
        if (order == null) return false;
        if (order.size() <= 1) return true;
        int root = order.get(order.size() - 1);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int rightBeginIndex = 0;
        for (int i = 0; i < order.size() - 1; i++) {
            if (order.get(i) < root) {
                left.add(order.get(i));
            } else {
                rightBeginIndex = i;
                break;
            }
        }
        for (int i = rightBeginIndex; i < order.size() - 1; i++) {
            if (order.get(i) > root) {
                right.add(order.get(i));
            } else {
                return false;
            }
        }
        return isTree(left) && isTree(right);






/*        int root = order[order.length - 1];
        int[] left = new int[order.length];
        int[] right = new int[order.length];
        int rightBeginIndex = 0;
        for (; rightBeginIndex < order.length - 1; rightBeginIndex++) {
            if (order[rightBeginIndex] < root) {
                left[rightBeginIndex] = order[rightBeginIndex];
            } else {
                break;
            }
        }

        for (int i = 0; rightBeginIndex < order.length - 1; rightBeginIndex++, i++) {
            if (order[rightBeginIndex] > root) {
                right[i] = order[rightBeginIndex];
            } else {
                break;
            }
        }
        return (rightBeginIndex == order.length - 1) && isTree(left) && isTree(right);*/
    }
}
