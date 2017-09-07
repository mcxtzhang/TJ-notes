package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/7.
 * History:
 */
public class Test109_ConvertSortedListtoBinarySearchTree {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (null == head) return null;
            //找到中间的节点
            ListNode f = head, s = head;
            //中间节点的前置节点 pre ，用于断链
            ListNode pre = null;
            //1234, s=2.   12345,s=3.正好都是中间的节点，中间的节点就是根节点
            while (f.next != null && f.next.next != null) {
                f = f.next.next;
                pre = s;
                s = s.next;
            }
            TreeNode root = new TreeNode(s.val);
            if (pre != null) {
                pre.next = null;
                root.left = sortedListToBST(head);
            } else {
                root.left = null;
            }
            //right
            root.right = sortedListToBST(s.next);

            return root;
        }
    }
}
