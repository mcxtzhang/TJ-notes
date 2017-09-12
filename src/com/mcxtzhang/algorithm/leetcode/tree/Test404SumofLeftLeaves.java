package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/12.
 * History:
 */
public class Test404SumofLeftLeaves {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            //思路:遍历时，加入 isLeft ，如果是叶子节点 同时 isLeft true ， 累加sum
            if (root == null) return sum;
            travesal(root, false);
            return sum;
        }

        public void travesal(TreeNode root, boolean isLeft) {
            if (root == null) return;
            if (root.left == null && root.right == null && isLeft) {
                sum += root.val;
            } else {
                travesal(root.left, true);
                travesal(root.right, false);
            }
        }
    }
}
