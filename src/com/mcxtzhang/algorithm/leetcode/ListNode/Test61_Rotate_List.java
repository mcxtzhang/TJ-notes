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
/*        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);*/
        head.next = node2;
/*        node2.next = node3;
        node3.next = node4;
        node4.next = node5;*/


        ListNode listNode = new Solution2().rotateRight(head, 3);
    }


    /** 和思路2 一样 只不过最后在步进时  可以少用一个指针
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution3 {
        //测试用例 12345, k = 0, 1 ,2 ,5 ,7
        public ListNode rotateRight(ListNode head, int k) {
            if (k < 1 || head == null) return head;
            //思路2：先遍历一遍链表，记录length，同时将首尾相连组成环形链表。
            //然后计算出K需要遍历的节点数，因为是倒数K个，所以是 (length- k)%length
            //遍历如上个节点数以后，将链表断开，返回。
            ListNode cur = head;
            int len = 1;
            while(cur.next!=null){
                len ++;
                cur = cur.next;
            }
            //环
            cur.next  = head;

            //计算出需要遍历的节点数
            int offset = len - k % len;

            //防止 1 1 这种情况


            //举例 1 2  ，k=1.  offset =1.结果2->1
            while(offset-->0){
                cur = cur.next;
            }
            head = cur.next;
            cur.next = null;
            return head;

        }
    }


    //思路2：先遍历一遍链表，记录length，同时将首尾相连组成环形链表。
    //然后计算出K需要遍历的节点数，因为是倒数K个，所以是 (length- k)%length
    //遍历如上个节点数以后，将链表断开，返回。


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution2 {
        //测试用例 12345, k = 0, 1 ,2 ,5 ,7
        public ListNode rotateRight(ListNode head, int k) {
            if (k < 1 || head == null) return head;
            //思路2：先遍历一遍链表，记录length，同时将首尾相连组成环形链表。
            //然后计算出K需要遍历的节点数，因为是倒数K个，所以是 (length- k)%length
            //遍历如上个节点数以后，将链表断开，返回。
            ListNode cur = head;
            int len = 1;
            while(cur.next!=null){
                len ++;
                cur = cur.next;
            }
            //环
            cur.next  = head;

            //计算出需要遍历的节点数
            int offset = len - k % len;

            //防止 1 1 这种情况
            ListNode tail = cur;
            cur = head;

            //举例 1 2  ，k=1.  offset =1.结果2->1
            while(offset>0){
                offset--;
                tail = cur;
                cur = cur.next;
            }
            tail.next = null;
            return cur;

        }
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
