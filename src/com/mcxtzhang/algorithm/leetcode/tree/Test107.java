package com.mcxtzhang.algorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Intro:
 * 107. Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/18.
 * History:
 */
public class Test107 {

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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            //广度遍历，每一层插入在List的头部，这样再顺序输出这个List就是逆序的结果
            List<List<Integer>> result = new LinkedList<>();
            if(root == null) return result;
            List<Integer> level;

            TreeNode toBeAdd ;
            Deque<TreeNode> temp = new LinkedList<>();
            temp.addLast(root);
            while(!temp.isEmpty()){
                int n = temp.size();
                level = new LinkedList<>();
                for(int i=0;i<n;i++){
                    toBeAdd = temp.removeFirst();
                    level.add(toBeAdd.val);
                    if(toBeAdd.left!=null)temp.add(toBeAdd.left);
                    if(toBeAdd.right!=null)temp.add(toBeAdd.right);
                }
                result.add(0,level);
            }
            return result;


        }
    }

}
