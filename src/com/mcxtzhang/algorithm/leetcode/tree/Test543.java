package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/16.
 * History:
 */
public class Test543 {
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
        int max;
        public int diameterOfBinaryTree(TreeNode root) {
            //对于每一个节点 都计算一下它的Diameter 最后取Diameter的最大值
            diameterOfNode(root);
            return max;
        }
        //返回值是node的深度，
        public int diameterOfNode(TreeNode node){
            if(null == node) return 0;
            int left = diameterOfNode(node.left);
            int right = diameterOfNode(node.right);
            //diameter是左右深度加起来
            max = Math.max(max,left+right);
            //返回的深度是 左右深度更大的+1
            return Math.max(left,right)+1;



        }
    }
}
