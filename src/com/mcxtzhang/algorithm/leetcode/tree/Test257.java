package com.mcxtzhang.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 * <p>
 * <p>
 * Created by mcxtzhang on 2017/9/21.
 */
public class Test257 {
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new LinkedList<>();
            if (root == null) return result;
            StringBuilder sb = new StringBuilder();
            preFirstTravesal(root, sb, result);
            return result;
        }

        public void preFirstTravesal(TreeNode root, StringBuilder pathSb, List<String> result) {
            if (null == root) return;
            //1 拼接
            pathSb.append(root.val);

            //2 叶子结点
            if (root.left == null && root.right == null) {
                result.add(pathSb.toString());

            } else { //3 不是叶子节点继续递归
                pathSb.append("->");

                preFirstTravesal(root.left, pathSb, result);
                preFirstTravesal(root.right, pathSb, result);
            }
            //4删除当前节点
            pathSb.delete(pathSb.lastIndexOf(String.valueOf(root.val)), pathSb.length());

        }
    }
}
