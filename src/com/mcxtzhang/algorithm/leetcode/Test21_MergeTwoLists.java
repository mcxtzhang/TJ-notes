package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro: Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/4.
 * History:
 */
public class Test21_MergeTwoLists {
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


    /**
     * recursion
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);

                return l1;
            } else {

                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }


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
