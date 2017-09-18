package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:
 Add to List
 108. Convert Sorted Array to Binary Search Tree
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/17.
 * History:
 */
public class Test108 {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            //排序数组-》二叉树。  每次取中间的元素 确定 二叉树的根节点 依次递归即可

            if(nums == null) return null;
            return convertArray2BST(nums,0,nums.length-1);

        }

        public TreeNode convertArray2BST(int[] nums,int begin,int end){
            if(nums == null || begin<0 || end <0  || begin >nums.length-1 || end>nums.length-1 || begin >end) return null;
            int middle = (begin +end)>>1;
            TreeNode root = new TreeNode (nums[middle]);
            root.left = convertArray2BST(nums,begin,middle-1);
            root.right = convertArray2BST(nums,middle+1,end);
            return root;
        }

    }
}
