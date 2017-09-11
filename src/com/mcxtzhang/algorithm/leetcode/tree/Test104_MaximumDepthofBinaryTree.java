package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/11.
 * History:
 */
public class Test104_MaximumDepthofBinaryTree {
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
        public int maxDepth(TreeNode root) {
            if (null == root) return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
