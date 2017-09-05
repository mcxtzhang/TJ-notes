package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/5.
 * History:
 */
public class Test82_RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        ListNode listNode = new Solution().deleteDuplicates(head);
        System.out.println(listNode);

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        //测试用例：空，empty。 11111,122221,12222,222221,12345,1223345,
        //利用它是排序数组，所以相等的一定是相邻元素
        public ListNode deleteDuplicates(ListNode head) {
            ListNode p = null, c = head;
            boolean remove = false;
            while (c != null) {
                while (c.next != null && c.next.val == c.val) {//需要删除
                    c.next = c.next.next;
                    remove = true;
                }
                if (remove) {
                    remove = false;
                    if (c.next != null) {
                        //覆盖
                        c.val = c.next.val;
                        //这里不需要前进，因为下一个指针也有可能是重复的指针
                        c.next = c.next.next;
                    } else {
                        //已经到尾部,需要删除操作
                        if (null == p) return null;
                        p.next = null;
                    }
                } else {
                    p = c;
                    c = c.next;
                }


            }
            return head;
        }
    }
}
