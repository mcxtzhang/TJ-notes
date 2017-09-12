package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/12.
 * History:
 */
public class Test538 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            if(null == root) return null;
            convertBST(root.right);
            root.val +=sum;
            sum = root.val;
            convertBST(root.left);

            return root;
        }

    }
}
