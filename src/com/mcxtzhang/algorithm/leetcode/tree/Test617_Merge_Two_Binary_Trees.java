package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/11.
 * History:
 */
public class Test617_Merge_Two_Binary_Trees {
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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(null == t1 ) return t2;
            if(null == t2 ) return t1;
            TreeNode root = new TreeNode(t1.val+t2.val);
            root.left = mergeTrees(t1.left,t2.left);
            root.right = mergeTrees(t1.right,t2.right);
            return root;
        }
    }
}
