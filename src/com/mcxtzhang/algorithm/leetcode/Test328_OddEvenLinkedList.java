package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/2.
 * History:
 */
public class Test328_OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (null == head || head.next == null) return head;
            //两个指针 分别指向 奇数头 偶数头 依次 步进二
            ListNode oddHead = head;
            ListNode evenHead = head.next;
            ListNode temp1 = oddHead, temp2 = evenHead;

            while (temp1 != null && temp2 != null) {
                if (temp1.next != null) {
                    temp1.next = temp1.next.next;
                }
                if (temp2.next != null) {
                    temp2.next = temp2.next.next;
                }
                if (temp1.next != null) temp1 = temp1.next;
                else {
                    temp1.next = evenHead;
                    break;
                }
                if (temp2.next != null) temp2 = temp2.next;
            }
            return oddHead;


        }
    }
}
