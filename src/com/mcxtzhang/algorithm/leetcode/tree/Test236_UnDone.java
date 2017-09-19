package com.mcxtzhang.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Intro:236. Lowest Common Ancestor of a Binary Tree
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * _______3______
 * /              \
 * ___5__          ___1__
 * /      \        /      \
 * 6      _2       0       8
 * /  \
 * 7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/19.
 * History:
 */
public class Test236_UnDone {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.left = node;
        TreeNode treeNode = new Solution().lowestCommonAncestor(root, root, node);

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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //
            //判断树是否包含某个节点 .
            //比较两个队列（栈），从后往前比较，第一个相等的节点就是CommonAncestor
            if (root == null || p == null || q == null) return null;
            List<TreeNode> list1 = new LinkedList<>();
            List<TreeNode> list2 = new LinkedList<>();

            containsNodeInTree(root, p, list1);
            containsNodeInTree(root, q, list2);

            if (list1.isEmpty() || list2.isEmpty()) return null;
            //两个for循环找到公共节点
            int lastIndex = -1;
            for (int i = 0 ; i < list1.size() ; i++) {
                for( int j = 0 ;  j< list2.size() ;j++){
                    if (list1.get(i) == list2.get(j)) {
                        lastIndex = i;
                    }
                }
            }
            if(lastIndex!=-1){
                return list1.get(lastIndex);
            }
            else{
                return null;
            }

        }


        //判断树是否包含某个节点
        ////前序遍历  ，每个节点入队列。 函数本身返回true false 代表是否找到。 如果返回false 要remove掉节点。
        //最终list 就是一条从根节点到目标节点的路径
        public boolean containsNodeInTree(TreeNode root, TreeNode node, List<TreeNode> list) {
            if (root == null || node == null) return false;
            list.add(root);
            if (root.val == node.val) return true;
            if (containsNodeInTree(root.left, node, list) || containsNodeInTree(root.right, node, list)) {
                return true;
            } else {
                list.remove(list.size() - 1);
                return false;
            }
        }
    }
}
