package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * iven a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/15.
 * History:
 */
public class Test24_SwapNodesinPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode n1 = head;
            ListNode n2 = n1.next;
            ListNode pre = null;

            while (true) {
                if (pre == null) {
                    head = n2;
                } else {
                    pre.next = n2;
                }
                n1.next = n2.next;
                n2.next = n1;
                pre = n1;

                if (n1.next != null && n1.next.next != null) {
                    n1 = n1.next;
                    n2 = n1.next;
                } else {
                    break;
                }
            }
            return head;
        }
    }
}
