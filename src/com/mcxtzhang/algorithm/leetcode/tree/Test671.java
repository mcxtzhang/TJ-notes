package com.mcxtzhang.algorithm.leetcode.tree;

/**
 * Intro:
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 * <p>
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * <p>
 * If no such second minimum value exists, output -1 instead.
 * <p>
 * Example 1:
 * Input:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input:
 * 2
 * / \
 * 2   2
 * <p>
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/17.
 * History:
 */
public class Test671 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
//测试用例：null, 有结果的 ，无结果的
    class Solution {
        int min;
        int result;

        public int findSecondMinimumValue(TreeNode root) {
            //特点 1 要么叶子 要么有两个孩子
            //2 父节点一定小于等于 所有孩子节点

            //思路 min = rootValue， result ，初始为int最大值。
            //遍历每个节点 判断， 1 节点值是否等于min，等于继续遍历子节点。  2 节点值是否大于min，如果是，且小于result。更新result。return。 如果否，return。
            if (null == root) return -1;
            min = root.val;
            result = Integer.MAX_VALUE;

            perTraversal(root);
            return result == Integer.MAX_VALUE ? -1 : result;

        }


        public void perTraversal(TreeNode root) {
            if (null == root) return;
            if (root.val == min) {
                perTraversal(root.left);
                perTraversal(root.right);
            } else if (root.val > min && root.val < result) {
                result = root.val;
                return;
            } else {
                return;
            }
        }
    }
}
