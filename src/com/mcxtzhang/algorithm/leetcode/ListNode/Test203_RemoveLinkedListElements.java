package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/2.
 * History:
 */
public class Test203_RemoveLinkedListElements {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            //要考虑head节点就等于val的情况。
            if (null == head) return head;
            ListNode now = head;
            ListNode pre = null;
            ListNode result = null;
            while (now != null) {
                if (val == now.val) {
                    if (pre == null) {
                    } else {
                        pre.next = now.next;
                    }
                } else {
                    if (pre == null) {
                        result = now;
                    }
                    pre = now;
                }
                now = now.next;
            }
            return result;
        }
    }
}
