package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:
 * 572. Subtree of Another Tree
 * <p>
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/17.
 * History:
 */
public class Test572 {
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
        public boolean isSubtree(TreeNode s, TreeNode t) {
            //思路： 遍历s树
            //如果根节点值相等，那么就递归判断子树的根节点值是否相等。
            //如果根节点值不相等，那么用左子树或者右子树为根，和 t比较
            if (s == null && t == null) return true;
            if (isSub(s, t)) return true;
            if (s != null) {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
            return false;


        }

        //严格判断两条树是否有包含关系 不负责遍历 只负责判断
        public boolean isSub(TreeNode s, TreeNode t) {
            if (s == null && t == null) return true;
            if (s == null || t == null) return false;
            if (s.val == t.val) {
                return isSub(s.left, t.left) && isSub(s.right, t.right);
            } else {
                return false;
            }
        }
    }
}
