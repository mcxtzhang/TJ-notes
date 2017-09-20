package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:101. Symmetric Tree
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/20.
 * History:
 */
public class Test101 {
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
        public boolean isSymmetric(TreeNode root) {
            //把左右子树拿出来比较， 问题转化成 比较两棵树 是否是镜像
            if(null == root) return true;
            return isMirrorTree(root.left, root.right);


        }

        public boolean isMirrorTree(TreeNode root1, TreeNode root2){
            if(root1 == null && root2 == null) return true;
            if(root1 == null || root2 == null) return false;
            if(root1.val != root2.val) return false;
            return isMirrorTree(root1.left,root2.right) && isMirrorTree(root1.right,root2.left);





        }
    }

}
