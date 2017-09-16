package com.mcxtzhang.algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Intro:
 * Given a binary tree, return the tilt of the whole tree.
 * <p>
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * <p>
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * <p>
 * Example:
 * Input:
 * 1
 * /   \
 * 2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 * <p>
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/15.
 * History:
 */
public class Test563_Binary_Tree_Tilt {
    //方法二 后序遍历 （左 右 中） 这样就不用缓存了
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        int sum = 0 ;//存的是所有节点的Tilt的累加和
        public int findTilt(TreeNode root) {
            if(root == null ) return 0 ;

            //每个节点的Tilt 是 左子树所有节点值的和 - 右子树所有节点值的和 的绝对值。
            //叶子结点 Tilt = 0 ,
            //整个树的Tilt是所有节点的Tilt累加和
            travesal(root);

            return sum;

        }

        public int travesal(TreeNode root){
            if(null == root) return 0 ;
            int leftSum = travesal(root.left);
            int rightSum = travesal(root.right);
            sum += Math.abs(leftSum-rightSum);
            return leftSum + rightSum + root.val;
        }

    }


    //方法一 傻逼 效率极低
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution1 {
        public int findTilt(TreeNode root) {
            if(root == null ) return 0 ;

            //每个节点的Tilt 是 左子树所有节点值的和 - 右子树所有节点值的和 的绝对值。
            //叶子结点 Tilt = 0 ,
            //整个树的Tilt是所有节点的Tilt累加和

            int sum = 0 ;
            List<TreeNode> temp = new LinkedList<>();
            temp.add(root);
            TreeNode n;
            while(!temp.isEmpty()){
                n = temp.remove(0);
                sum += findNodeTilt(n);
                if(n.left!=null) temp.add(n.left);
                if(n.right!=null) temp.add(n.right);
            }
            return sum;

        }
        //找到某个节点的Tilt
        public int findNodeTilt(TreeNode node){
            if(node == null) return 0;
            return Math.abs(findTreeSum(node.left) -findTreeSum(node.right)) ;
        }

        //找出某个树的所有节点的和
        public int findTreeSum(TreeNode node){
            if(node == null ) return 0 ;
            int sum = 0 ;
            List<TreeNode> temp = new LinkedList<>();
            temp.add(node);
            TreeNode n;
            while(!temp.isEmpty()){
                n = temp.remove(0);
                sum+=n.val;
                if(n.left!=null) temp.add(n.left);
                if(n.right!=null) temp.add(n.right);
            }
            return sum;

        }

    }
}
