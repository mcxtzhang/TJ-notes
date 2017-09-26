package com.mcxtzhang.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Find Mode in Binary Search Tree
 * <p>
 * <p>
 * Created by mcxtzhang on 2017/9/22.
 */
public class Test501 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = null;
        TreeNode node5 = null;
        TreeNode node6 = new TreeNode(2);
        root.left = node2;
        root.right = node3;
        node3.left = node6;
        new Solution().findMode(root);

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
   static class Solution {
        public int[] findMode(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            //中序遍历，结果是有序的。
            //pre：上一个值   ,result 结果. maxCount:最大重复数量， count：当前重复数量
            //依次比较，如果 值和pre相等，count++, 不想等，1 比较count 和 maxCount ， 大于maxCount 要晴空result 再add。 等于 add。小于啥都不敢，2 并且 count=0;
            //
            midTravesals(root, result);
            if (count > maxCount) {
                result.clear();
                result.add(pre);
            } else if (count == maxCount && pre != null && pre != result.get(result.size() - 1)) {
                result.add(pre);
            }

            int[] temp = new int[result.size()];
            int len = temp.length;
            for (int i = 0; i < len; i++) {
                temp[i] = result.get(i);
            }


            return temp;

        }

        Integer pre;
        int maxCount;
        int count;

        public void midTravesals(TreeNode root, List<Integer> result) {
            if (null == root) return;
            midTravesals(root.left, result);

            if (pre == null) {
                pre = root.val;
                count = 1;
            } else {
                if (pre.equals(root.val)) {
                    count++;
                } else {
                    if (count > maxCount) {
                        maxCount = count;
                        result.clear();
                        result.add(pre);
                    } else if (count == maxCount) {
                        result.add(pre);
                    } else {

                    }
                    count = 1;
                }
                pre = root.val;
            }

            midTravesals(root.right, result);

        }
    }
}
