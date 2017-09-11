package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro: 669. Trim a Binary Search Tree
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/11.
 * History:
 */
public class Test669_Trim_a_Binary_Search_Tree {

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
        public TreeNode trimBST(TreeNode root, int L, int R) {
            //中序遍历每个节点， 判断节点的val是否在(L,R)内。如果在不操作。 如果<L,将right赋值给当前节点。并继续判断. 如果>R,将左子树赋值给自身，继续判断。
            if (root == null) return null;
            if (root.val < L) {//砍掉左边和自己
                return trimBST(root.right, L, R);
            } else if (root.val > R) {//砍掉右边和自己
                return trimBST(root.left, L, R);
            }
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;

        }
    }
}
