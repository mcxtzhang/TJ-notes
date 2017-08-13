package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro: 反转链表
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/13.
 * History:
 */
public class Test206_ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class Solution {
        //一个指针保存前一个，一个指针保存现在。 另外的指针做临时的下一个，以及结果
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode pre = head;
            ListNode now = head.next;
            pre.next = null;
            ListNode result = null;

            while (now != null) {
                result = now.next;
                now.next = pre;
                pre = now;
                if (result != null) {
                    now = result;
                } else {
                    result = now;
                    now = null;
                }
            }
            return result;
        }
    }

}
