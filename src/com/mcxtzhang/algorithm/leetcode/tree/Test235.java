package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro: 235. Lowest Common Ancestor of a Binary Search Tree
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * _______6______
 * /              \
 * ___2__          ___8__
 * /      \        /      \
 * 0      _4       7       9
 * /  \
 * 3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/19.
 * History:
 */
public class Test235 {
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //前序遍历，比较节点的值
            // root值大于 这两个节点的值 则，去左子树找。  小于去右字数找。 在中间 就是它了
            if(root == null || p ==null || q == null) return null;
            if(root.val>p.val && root.val>q.val){
                return lowestCommonAncestor(root.left,p,q);
            }else if(root.val<p.val && root.val<q.val){
                return lowestCommonAncestor(root.right,p,q);
            }else{
                return root;
            }



        }
    }
}
