package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:Remove Nth Node From End of List
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/5.
 * History:
 */
public class Test19_ {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) return null;
            if (n <= 0) return null;

            ListNode tail = head;//两个指针 一快一慢
            ListNode temp = head;

            while (tail != null) {
                if (n >= 0) {
                    n--;//先走N+1步
                } else {
                    temp = temp.next;
                }
                tail = tail.next;
            }
            if (n < 0 && temp.next != null) {//normal remove middle
                temp.next = temp.next.next;
                return head;
            } else if (n == 0) {//remove head  N等于链表长度了
                head = head.next;
                return head;
            } else {//n 大于链表 返回 null
                return null;
            }


        }
    }
}
