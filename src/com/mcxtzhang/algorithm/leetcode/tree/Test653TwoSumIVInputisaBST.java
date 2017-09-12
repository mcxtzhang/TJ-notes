package com.mcxtzhang.algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/12.
 * History:
 */
public class Test653TwoSumIVInputisaBST {
    public static void main(String[] args) {
/*        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);

        root.left = root2;
        root.right = root3;

        root2.left = root4;
        root2.right = root5;
        root3.right = root6;
                boolean target = new Solution().findTarget(root, 28);  */

        TreeNode root = new TreeNode(2);

        TreeNode root3 = new TreeNode(3);


        root.left = null;
        root.right = root3;

        boolean target = new Solution().findTarget(root, 6);

        System.out.println(target);
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
        //先进行一次遍历，将 k -val 存入map ，并且存入index
        //然后再遍历一次，如果val 在map中找到了index，比较index和自身是否相等。不相等 就是true。 index用于防止节点的值正好是k的一半。

        int index;

        public boolean findTarget(TreeNode root, int k) {
            if (null == root) return false;
            index = 0;
            Map<Integer, Integer> cache = new HashMap<>();
            travesalTree(root, cache, k);
            index = 0;
            return findTarget(root, cache, k);
        }

        public void travesalTree(TreeNode root, Map<Integer, Integer> map, int k) {
            if (null == root) return;
            map.put(k - root.val, index++);
            travesalTree(root.left, map, k);
            travesalTree(root.right, map, k);
        }

        public boolean findTarget(TreeNode root, Map<Integer, Integer> map, int k) {
            if (root == null) return false;
            Integer i = map.get(root.val);
            if (i != null && i != index) {
                return true;
            }
            index++;
            return findTarget(root.left, map, k) || findTarget(root.right, map, k);
        }
    }
}
