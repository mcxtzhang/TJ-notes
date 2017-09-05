package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/5.
 * History:
 */
public class Test92_ReverseLinkedListII {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        //考虑边界情况，1~5,  1~4, 2~5, 普通情况：2~4,
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy1 = new ListNode(0);
            ListNode dummy2 = new ListNode(0);
            ListNode cur1 = dummy1, tail2 = null;
            int num = 1;
            ListNode temp;
            while (head != null) {
                if (num < m) {
                    cur1.next = head;
                    cur1 = cur1.next;
                    head = head.next;
                } else if (num <= n) {
                    temp = head;
                    head = head.next;

                    temp.next = dummy2.next;
                    dummy2.next = temp;
                    if (tail2 == null) {
                        tail2 = temp;
                    }

                } else {
                    break;
                }
                num++;
            }

            if (dummy1.next == null) {
                if (head != null) {//1~4,头空，但是尾部需要拼接,break跳出的
                    tail2.next = head;
                }
                return dummy2.next;
            } else {
                if (dummy2.next != null) {//需要拼接 (适配情况 2~5,2~4) ::::头不空，但是需要拼接中间以及尾部 不管他是不是break跳出的
                    cur1.next = dummy2.next;
                    tail2.next = head;
                }
                return dummy1.next;
            }
        }
    }
}
