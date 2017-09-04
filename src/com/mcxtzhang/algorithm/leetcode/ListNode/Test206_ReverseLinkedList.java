package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro: 反转链表
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/13.
 * History:
 */
public class Test206_ReverseLinkedList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;

        ListNode listNode = new Solution4().reverseList(head);
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
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //20170831   beats26.2%
    public static class Solution4 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            //loop
            ListNode pre =null;
            ListNode cur=null;
            while(head!=null){
                if(null==pre){
                    pre = head;
                    head = head.next;
                    pre.next =null;
                }else{
                    cur = head;
                    head = head.next;
                    cur.next= pre;
                    pre = cur;
                }
            }
            return cur;


        }

    }



    //递归 ok
    public class Solution3 {

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            return reverseSegment(null, head);
        }


        public ListNode reverseSegment(ListNode left, ListNode right) {
            if (right == null) return null;
            if (right.next == null) {//根节点
                right.next = left;
                return right;
            } else {
                ListNode listNode = reverseSegment(right, right.next);
                right.next = left;
                return listNode;
            }

        }
    }

    public class Solution2 {
        //每一个都将原head的现在的下一个node移到 现在的head处
        //以前的head 是现在的tail，所以heade。next 为null ，结束
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode result = head;
            ListNode temp = null;
            while (head.next != null) {
                temp = result;
                result = head.next;
                head.next = head.next.next;
                result.next = temp;
            }
            return result;
        }
    }


    //beats 27%
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
