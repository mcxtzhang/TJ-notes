package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro: Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/4.
 * History:
 */
public class Test21_ {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //only beats 22%
    public static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = null;
            ListNode tail = null;
            while (l1 != null || l2 != null) {
                if ((l1 != null && l2 != null && l1.val < l2.val) || (l1 != null && l2 == null)) {
                    if (result == null) {
                        result = l1;
                        tail = l1;
                    } else {
                        tail.next = l1;
                        tail = tail.next;
                    }
                    l1 = l1.next;
                } else {
                    if (result == null) {
                        result = l2;
                        tail = l2;
                    } else {
                        tail.next = l2;
                        tail = tail.next;
                    }
                    l2 = l2.next;
                }
            }
            return result;
        }
    }
}
