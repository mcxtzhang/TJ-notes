package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:Add Two Numbers
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/1.
 * History:
 */
public class Test2_AddTwoNum {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (null == l1 || null == l2) return null;

            ListNode result = null;
            ListNode tailNode = result;
            int temp = 0;//保存中间结果  或者进位

            while (l1 != null && l2 != null) {
                temp = l1.val + l2.val + temp;
                if (temp >= 10) {
                    if (null == tailNode) {
                        tailNode = new ListNode(temp - 10);
                        result = tailNode;
                    } else {
                        tailNode.next = new ListNode(temp - 10);
                        tailNode = tailNode.next;
                    }
                    temp = 1;
                } else {
                    if (null == tailNode) {
                        tailNode = new ListNode(temp);
                        result = tailNode;
                    } else {
                        tailNode.next = new ListNode(temp);
                        tailNode = tailNode.next;
                    }
                    temp = 0;
                }
                if (result == null) {
                    result = tailNode;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                if (l1.val + temp >= 10) {
                    tailNode.next = new ListNode(l1.val + temp - 10);
                } else {
                    tailNode.next = new ListNode(l1.val + temp);
                    temp = 0;
                }
                tailNode = tailNode.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                if (l2.val + temp >= 10) {
                    tailNode.next = new ListNode(l2.val + temp - 10);
                } else {
                    tailNode.next = new ListNode(l2.val + temp);
                    temp = 0;
                }
                tailNode = tailNode.next;
                l2 = l2.next;
            }
            if (temp != 0) {
                tailNode.next = new ListNode(1);
            }

            return result;

        }
    }
}
