package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/10.
 * History:
 */
public class Test61_Rotate_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ListNode listNode = new Solution().rotateRight(head, 2000000000);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    //超时了
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        //测试用例 12345, k = 0, 1 ,2 ,5 ,7
        public ListNode rotateRight(ListNode head, int k) {
            if (k < 1 || head == null) return head;
            //用快慢指针找到需要断开的节点 temp， temp.next 就是旋转后的头节点，然后遍历到尾部链接到原本的head 即可
            ListNode f = head, s = head;
            ListNode temp = null;
            ListNode result;

            // 考虑k可能远大于链表长度的情况，所以还需要记录链表长度 取余
            int length = 0;

            while (k > 0) {
                //k大于链表长度
                if(length>0){
                    k = k %length;
                }

                f = head;
                while (f != null) {
                    length++;
                    if (k < 1) {
                        temp = s;
                        s = s.next;
                        f = f.next;
                    } else {
                        f = f.next;
                        k--;
                    }
                }
            }

            //不旋转(temp 是尾节点 说明不需要旋转)
            if (temp==null || temp.next == null) {
                return head;
            }
            result = temp.next;
            //temp其实是旋转后里链表的尾节点
            temp.next = null;
            //temp用于步进
            temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = head;


            return result;


        }
    }
}
